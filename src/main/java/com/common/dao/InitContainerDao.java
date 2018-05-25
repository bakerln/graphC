package com.common.dao;

import com.display.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by LiNan on 2018-05-24.
 * Description:
 */

@Repository
public class InitContainerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Group getGroup(String groupName) {
        Object[] param = {groupName};
        String sql = "select * from JX_TX_GROUP where GROUP_NAME = ?";
        return jdbcTemplate.queryForObject(sql,param,Group.class);
    }
}
