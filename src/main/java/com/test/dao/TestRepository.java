package com.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by LiNan on 2018-04-09.
 * Description:
 */
@Repository
public class TestRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List getData(){
        String sql = "select * from tz_xcxx where zmlm = 'RXH'";
        return jdbcTemplate.queryForList(sql);
    }
}
