package com.display.controller;
import com.display.vo.GroupVO;
import com.display.vo.AreaVO;
import com.display.service.DisplayService;
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
        List<Area> areaList = displayService.getArea();

        //List<GroupVO> groupList = displayService.getGroup();

       // List<Container> containerList = initContainerService.getContainer();

        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
      //  initMap.put("groupList",groupList);
       // initMap.put("containerList",containerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));

        //TODO px2pos
        //TODO px2size

        //groupList
        //TODO px2pos
        //TODO px2size
    }

    /**
     *  update databases to get current data
     * @param response
     */
    //实时展示
    @RequestMapping(value = "/show")
    public void show(HttpServletResponse response){
        //areaList
        //TODO px2pos
        //TODO px2size

        //groupList
        //TODO px2pos
        //TODO px2size

        //containerList
        //TODO px2pos
        //TODO px2size
    }

    //单个集装箱
    @RequestMapping(value = "/planSingle")
    public void planSingle(String containerName){
        //TODO return all and the one for current and plan
        //TODO and change url

    }

    //一个区域数据
    @RequestMapping(value = "planArea")
    public void planArea(List containerNameList){
        //TODO return all and the area for current and plan
        //TODO and change url
    }
}
