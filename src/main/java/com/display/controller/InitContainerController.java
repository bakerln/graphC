package com.display.controller;

import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import com.display.model.AreaTest;
import com.display.model.ContainerTest;
import com.display.model.GroupTest;
import com.display.service.InitContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-04-17.
 * Description: 箱场初始化
 */
@Controller
@RequestMapping(value = "/displayTest")
public class InitContainerController {

    @Autowired
    private InitContainerService initContainerService;

    @RequestMapping(value = "/init")
    public void initContainerYard(HttpServletResponse response){
        List<AreaTest> areaList = initContainerService.getArea();

        List<GroupTest> groupList = initContainerService.getGroup();

        List<ContainerTest> containerList = initContainerService.getContainer();

        Map initMap = new HashMap();
        initMap.put("areaList",areaList);
        initMap.put("groupList",groupList);
        initMap.put("containerList",containerList);

        WebUtil.out(response, JsonUtil.toStr(initMap));
    }
}
