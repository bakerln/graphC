package com.common.controller;

import com.common.service.InitContainerService;
import com.config.interceptor.ResultMsg;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import com.display.model.Group;
import com.display.service.DisplayService;
import com.display.vo.GroupVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LiNan on 2018-05-10.
 * Description:
 */
@Controller
@RequestMapping(value = "/imp")
public class InitContainerController {
    @Autowired
    private InitContainerService initContainerService;

    /**
     * 新建一个集装箱
     * @param response
     */
    @RequestMapping(value = "/initContainer")
    public void initContainer(HttpServletResponse response,String groupName,String container){

        HashMap containerMap = (HashMap) JsonUtil.toObject(container,Map.class);

        Group group = initContainerService.getGroup(groupName);

        ResultMsg resultMsg = initContainerService.addContainer(group,containerMap);

        WebUtil.out(response, JsonUtil.toStr(resultMsg));

    }

}
