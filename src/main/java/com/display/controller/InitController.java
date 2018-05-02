package com.display.controller;
import com.config.util.json.JsonUtil;
import com.display.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 初始化箱场
 */
@Controller
@RequestMapping(value = "/init")
public class InitController {

    @Autowired
    private InitService initService;


    /**
     *  初始化箱场，通过版本记录
     *  use AreaVO\GrouopVO get value and put into MODEL to save
     * @param response
     */

    @RequestMapping(value = "/initElement")
    public void addElement(HttpServletResponse response, String areaList, String groupList,String test){

        ArrayList test2 = (ArrayList) JsonUtil.toObject(areaList,List.class);
        initService.initArea(test2);
        //areaList
        //TODO px2pos
        //TODO px2size

        ArrayList test1 = (ArrayList) JsonUtil.toObject(groupList,List.class);
        initService.initGroup(test1);
        //groupList
        //TODO px2pos
        //TODO px2size
        //TODO px2hb


    }

}
