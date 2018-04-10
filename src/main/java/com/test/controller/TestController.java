package com.test.controller;

import com.common.redis.RedisUtil;
import com.common.util.date.DateUtil;
import com.common.util.web.WebUtil;
import com.test.dto.Test;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-04-03.
 * Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;
    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/getValue")
    public void getData(){
        testService.getData();
    }

    @RequestMapping(value = "/redis")
    public void addRedis(HttpServletResponse httpServletResponse,String id){
        String date = DateUtil.getSystemTime();
        redisUtil.set(id,date,60);
        WebUtil.out(httpServletResponse,"success");
    }

    @RequestMapping(value = "/getRedis")
    public void getRedis(HttpServletResponse httpServletResponse,String id){
        WebUtil.out(httpServletResponse,testService.getRedis(id));
    }
    @RequestMapping(value = "/false")
    public ModelAndView getfalse(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("false");
        return mv;
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.setName("haem");
        System.out.println(test.getName());
    }

}

