package com.test.controller;

import com.config.redis.RedisUtil;
import com.config.util.date.DateUtil;
import com.config.util.web.WebUtil;
import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by LiNan on 2018-04-03.
 * Description:
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private int a = 1;


    @Autowired
    private TestService testService;
    @Autowired
    private RedisUtil redisUtil;



    @RequestMapping(value = "/getValue")
    public void getData(HttpServletResponse response){
//        testService.getData();
        WebUtil.out(response,testService.toString());
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

    @RequestMapping(value = "/hello")
    public void getResponse(HttpServletResponse response,String test) throws InterruptedException {
        if (test.equals("on")){
            a += 1;
            System.out.println("begin to sleep");
            Thread.currentThread().sleep(10000);
            System.out.println("end of sleep");
            WebUtil.out(response,"awake");

            a += 10;
        }else{
            WebUtil.out(response,test + " from class " + this.a);
        }

    }

    public static void main(String[] args) {
        String a = "(120 120 230)";
        String[] b = a.split(" ");
        String c = b[2].replace(")","");
        int d = Integer.parseInt(c);
        int x = d + 1;
        System.out.println(x);
    }

}

