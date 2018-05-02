package com.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiNan on 2018-04-27.
 * Description: 作业计划
 */
@Controller
@RequestMapping(value = "/plan")
public class PlanController {


    @RequestMapping(value = "/addPlan")
    public void addPlan(){

    }


    @RequestMapping(value = "updatePlan")
    public void updatePlan(){

    }

    @RequestMapping(value = "completePlan")
    public void completePlan(){

    }
}
