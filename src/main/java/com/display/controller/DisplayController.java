package com.display.controller;
import com.display.service.DisplayService;
import com.display.vo.ContainerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import java.util.ArrayList;

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
        List<Area> areaList = displayService.getArea();
        //groupList
        List<Group> groupList = displayService.getGroup();
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
        List<Area> areaList = displayService.getArea();
        //groupList
        List<Group> groupList = displayService.getGroup();
        //containerList
        List<Container> containerList = displayService.getContainer();
        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        initMap.put("containerList",containerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }

    //单个集装箱
//    @RequestMapping(value = "/planSingle")
//    public void planSingle(HttpServletResponse response,String containerID){
//        ArrayList oldContainerList = (ArrayList) JsonUtil.toObject(containerID,List.class);
//        String oldContainerID = (String)oldContainerList.get(3);
////        String newContainerID = displayService.getNewContainerID(oldContainerID);
////        ContainerVO oldContainer = displayService.getContainerByID(oldContainerID);
////        ContainerVO newContainer = displayService.getContainerByID(newContainerID);
//        //areaList
//        List<Area> areaList = displayService.getArea();
//        //groupList
//        List<Group> groupList = displayService.getGroup();
//
//        Map initMap = new HashMap();
//        initMap.put("areaList",areaList);
//        initMap.put("groupList",groupList);
//        initMap.put("oldContainerList",oldContainer);
////        initMap.put("newContainerList",newContainer);
//
//        WebUtil.out(response, JsonUtil.toStr(initMap));
//    }

    //一个区域数据
    @RequestMapping(value = "planArea")
    public void planArea(String  containerNameList){
        //TODO get containerList via JX_TX_GROUP (group_belong = area key)

        //
    }
}
