package com.test.service;

import org.springframework.stereotype.Service;

/**
 * Created by LiNan on 2018-04-03.
 * Description:
 */
@Service
public class TestService {

    public void helloWorld(String id){
        System.out.println(id);
    }
}
