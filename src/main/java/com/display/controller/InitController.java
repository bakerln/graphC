package com.display.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 初始化箱场
 */
@RequestMapping(value = "/init")
public class InitController {

    /**
     *  use AreaVO\GrouopVO get value and put into MODEL to save
     *
     */
    //添加箱场元素
    @RequestMapping(value = "/addElement")
    public void addElement(List areaList,List groupList){
        //areaList
        //TODO px2pos
        //TODO px2size

        //groupList
        //TODO px2pos
        //TODO px2size
        //TODO px2hb
    }

    //删除箱场元素
    @RequestMapping(value = "/deleteElement")
    public void deleteElement(){

    }

    //修改箱场元素
    @RequestMapping(value = "updateElemtent")
    public void updateElement(){

    }
}
