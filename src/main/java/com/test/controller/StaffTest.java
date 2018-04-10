package com.test.controller;

import com.test.service.StaffService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by LiNan on 2018-04-10.
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/applicationContext.xml"})
public class StaffTest {
    @Autowired
    private StaffService staffService;

    @Test
    public void testAdd() {
        staffService.add();
    }

}
