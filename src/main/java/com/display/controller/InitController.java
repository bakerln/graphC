package com.display.controller;
import java.util.Map;
import com.config.interceptor.ResultMsg;
import com.config.util.json.JsonUtil;
import com.config.util.session.SessionUtil;
import com.config.util.session.UserSession;
import com.display.service.InitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.display.vo.AreaVO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by LiNan on 2018-04-25.
 * Description: 初始化箱场
 */
@RequestMapping(value = "/init")
public class InitController {

    @Autowired private InitService initService;


    /**
     * 初始化箱场，通过版本记录
     *  use AreaVO\GrouopVO get value and put into MODEL to save
     * @param response
     */

    @RequestMapping(value = "/initElement")
    public void addElement(HttpServletResponse response,String areaList,String groupList,AreaVO areaVO){

        ArrayList test = (ArrayList) JsonUtil.toObject(areaList,List.class);
        List<AreaVO> initAreaList = InitService.initArea;
        //areaList
        //TODO px2pos
        //TODO px2size

        ArrayList test1 = (ArrayList) JsonUtil.toObject(groupList,List.class);
        List<AreaVO> initGroupList = InitService.initGroup;
        //groupList
        //TODO px2pos
        //TODO px2size
        //TODO px2hb


        Map initMap = new HashMap();
        initMap.put("initAreaList",initAreaList);
        initMap.put("initGroupList",initGroupList);
    }

}
