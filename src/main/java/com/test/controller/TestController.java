package com.test.controller;

import com.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LiNan on 2018-04-03.
 * Description:
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping(value = "helloWorld")
    public void helloworld(String id){
        testService.helloWorld(id);
        System.out.println(id);
    }



}

