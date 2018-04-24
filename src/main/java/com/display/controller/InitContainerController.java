package com.display.controller;

import com.common.util.json.JsonUtil;
import com.common.util.web.WebUtil;
import com.display.model.Area;
import com.display.model.Container;
import com.display.model.Group;
import com.display.service.InitContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-04-17.
 * Description: 箱场初始化
 */
@Controller
@RequestMapping(value = "/display")
public class InitContainerController {

    @Autowired
    private InitContainerService initContainerService;

    @RequestMapping(value = "/init")
    public void initContainerYard(HttpServletResponse response){
        List<Area> areaList = initContainerService.getArea();

        List<Group> groupList = initContainerService.getGroup();

        List<Container> containerList = initContainerService.getContainer();

        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        initMap.put("containerList",containerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }
}
