package com.display.controller;
import com.config.interceptor.ResultMsg;
import com.display.service.DisplayService;
import com.display.vo.AreaVO;
import com.display.vo.ContainerVO;
import com.display.vo.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 箱场展示
 */

@RequestMapping(value = "/display")
@Controller

public class DisplayController {

    @Autowired
    private DisplayService displayService;

    /**
     * 信息展示
     * @param response
     * @param
     */

    //仅返回Arealist、grouplist
    @RequestMapping(value = "/showArea")
    public void initContainerYard(HttpServletResponse response){
        //areaList
        List<AreaVO> areaList = displayService.getAreaList();
        //groupList
        List<GroupVO> groupList = displayService.getGroupList();
        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        WebUtil.out(response, JsonUtil.toStr(initMap));

    }

    /**
     *  update databases to get current data
     * @param response
     */
    //实时展示
    @RequestMapping(value = "/show")
    public void show(HttpServletResponse response){
        //areaList
        List<AreaVO> areaList = displayService.getAreaList();
        //groupList
        List<GroupVO> groupList = displayService.getGroupList();
        //containerList
        List<ContainerVO> containerList = displayService.getContainerList();
        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        initMap.put("containerList",containerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }

    //单个集装箱计划
    @RequestMapping(value = "/planSingle")
    public void planSingle(HttpServletResponse response,String oldContainerName){

        //via Plan
        String newContainerID = displayService.getPlanContainerIDbyName(oldContainerName);

        ContainerVO oldContainer = displayService.getContainer(oldContainerName,"2");
        ContainerVO newContainer = displayService.getContainer(newContainerID,"1");

        ResultMsg resultMsg;
        if (oldContainer == null){
            resultMsg = new ResultMsg("P0011","箱场无该箱号","");
        } else if (newContainer == null){
            resultMsg = new ResultMsg("P0012","该箱号无计划","");
        }else resultMsg = new ResultMsg("P0010","success","");

        //areaList
        List<AreaVO> areaList = displayService.getAreaList();
        //groupList
        List<GroupVO> groupList = displayService.getGroupList();

        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        if (oldContainer != null){
            initMap.put("oldContainer",oldContainer);
        }
        if (newContainer != null){
            initMap.put("newContainer",newContainer);
        }
        initMap.put("resultMsg",resultMsg);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }


    //区域计划
    @RequestMapping(value = "planArea")
    public void planArea(HttpServletResponse response,String areaKey){
        //查找该区域的ContainerID(group_belong = area key)
        List containerIDList = displayService.getContainerIDList(areaKey);
        //查找该区域的PlanContainerID
        List containerPlanIDList = displayService.getPlanContainerList(containerIDList);
        //TODO 通过固定方法去查询箱子信息
        List<ContainerVO> containerList = displayService.ContainerList(containerIDList);
        List<ContainerVO> newContainerList = displayService.ContainerList(containerPlanIDList);


        //areaList
        List<AreaVO> areaList = displayService.getAreaList();
        //groupList
        List<GroupVO> groupList = displayService.getGroupList();

        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        initMap.put("containerList",containerList);
        initMap.put("newContainerList",newContainerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }
}
