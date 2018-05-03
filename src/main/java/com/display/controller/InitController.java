package com.display.controller;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
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
     * @param response
     */

    @RequestMapping(value = "/initElement")
    public void addElement(HttpServletResponse response, String areaList, String groupList){
        //areaList
        ArrayList area = (ArrayList) JsonUtil.toObject(areaList,List.class);
        initService.addInitArea(area);

        //groupList
        ArrayList group = (ArrayList) JsonUtil.toObject(groupList,List.class);
        initService.addInitGroup(group);

        WebUtil.out(response, JsonUtil.createOperaStr(true,"init success"));
    }

}
