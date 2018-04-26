package com.display.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 箱场展示
 */
@RequestMapping(value = "/display")
public class DisplayController {



    //实时展示
    @RequestMapping(value = "/show")
    public void initContainerYard(HttpServletResponse response){
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
        //TODO return current and plan
        //TODO and change url

    }

    //一个区域数据删除
    @RequestMapping(value = "planArea")
    public void planArea(List containerNameList){
        //TODO return current and plan
        //TODO and change url
    }
}
