package com.plan.controller;

import com.config.interceptor.ResultMsg;
import com.config.util.json.JsonUtil;
import com.config.util.web.WebUtil;
import com.plan.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * Created by LiNan on 2018-04-27.
 * Description: 作业计划
 */
@Controller
@RequestMapping(value = "/plan")
public class PlanController {

    @Autowired
    PlanService planService;

    @RequestMapping(value = "/addPlan")
    public void addPlan(HttpServletResponse response, String plan,String containerId,String planContainer){
        HashMap planContainerMap = (HashMap) JsonUtil.toObject(planContainer,HashMap.class);
        HashMap planMap = (HashMap) JsonUtil.toObject(plan,HashMap.class);

        ResultMsg resultMsg = planService.addPlan(containerId,planContainerMap,planMap);

        WebUtil.out(response, JsonUtil.toStr(resultMsg));
    }

    @RequestMapping(value = "/updatePlan")
    public void updatePlan(HttpServletResponse response, String plan,String containerId,String planContainer){
        HashMap planContainerMap = (HashMap) JsonUtil.toObject(planContainer,HashMap.class);
        HashMap planMap = (HashMap) JsonUtil.toObject(plan,HashMap.class);

        planService.updatePlan(containerId,planContainerMap,planMap);

        WebUtil.out(response, JsonUtil.toStr(new ResultMsg("P0020","修改计划成功","")));
    }

    @RequestMapping(value = "/deletePlan")
    public void deletePlan(HttpServletResponse response,String containerId){
        //计划箱id
        planService.deletePlan(containerId);

        WebUtil.out(response, JsonUtil.toStr(new ResultMsg("P0030","删除计划成功","")));

    }
    @RequestMapping(value = "completePlan")
    public void completePlan(){

    }
}
