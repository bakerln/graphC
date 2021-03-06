package com.test.service;

import com.config.redis.RedisUtil;
import com.test.dao.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LiNan on 2018-04-03.
 * Description:
 */
@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private RedisUtil redisUtil;

    public void getData(){
        List data = testRepository.getData();
        for (Object a:data) {
            System.out.println(a);
        }
    }

    public String getRedis(String id) {
//        throw new RuntimeException("error");
        String a = redisUtil.get(id);
        return a;
    }
}
