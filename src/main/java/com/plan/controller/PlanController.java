package com.plan.controller;

import com.config.util.web.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-04-27.
 * Description: 作业计划
 */
@Controller
@RequestMapping(value = "/plan")
public class PlanController {


    @RequestMapping(value = "/addPlan")
    public void addPlan(HttpServletResponse response, String containerID){
        WebUtil.out(response,"success");
    }


    @RequestMapping(value = "updatePlan")
    public void updatePlan(){

    }

    @RequestMapping(value = "completePlan")
    public void completePlan(){

    }
}
