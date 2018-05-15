package com.common.controller;

import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import com.display.service.DisplayService;
import com.display.vo.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by LiNan on 2018-05-10.
 * Description:
 */
@Controller
@RequestMapping(value = "/imp")
public class InitContainerController {
    @Autowired
    private DisplayService displayService;

    /**
     *
     * @param response
     */
    //仅返回Arealist、grouplist
    @RequestMapping(value = "/initContainer")
    public void initContainer(HttpServletResponse response){
        //groupList
        List<GroupVO> groupList = displayService.getGroupList();
        //add Container


        WebUtil.out(response, JsonUtil.toStr(""));

    }

}
