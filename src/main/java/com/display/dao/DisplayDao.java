package com.display.dao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;




    @Repository
    public class DisplayDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Area> getArea() {
        String sql = "select * from JX_TX_AREA where FLAG = '0'";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        List<Area> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Area.class));
        return list;
    }
        public List<Group> getGroup() {
            String sql = "select * from JX_TX_GROUP where FLAG = '0'";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            List<Group> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Group.class));
            return list;
        }

        public List<Container> getContainer() {
            String sql = "select * from JX_TX_CONTAINER where ISPLAN = '0'";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
            return list;
        }
        public Container getContainerByName(String param) {
            Object[] params = new Object[] { param };
            String sql = "select * from JX_TX_CONTAINER where ISPLAN = '0' AND CONTAINER_NAME = ?";
            List<Container> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Container.class));
            return list.get(0);
        }
        public Container getContainerByID(String containerID) {
            Object[] params = new Object[] { containerID };
            String sql = "select * from JX_TX_CONTAINER where CONTAINER_ID = ?";
            List<Container> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Container.class));
            return list.get(0);
        }

        public String getPlanContainerID(String oldContainerID) {
            Object[] params = new Object[] { oldContainerID };
            String sql = "select NEW_CONTAINER_ID from JX_TX_PLAN where flag = 'ZN02' and OLD_CONTAINER_ID = ?";
            List list = jdbcTemplate.queryForList(sql,params);
            if(list.size()==0){
                return "";
            }else{
                HashMap map = (HashMap)list.get(0);
                return  (String) map.get("NEW_CONTAINER_ID");
            }
        }

        public List getContainerIDList(String group_belong) {
            Object[] params = new Object[] { group_belong };
            String sql = "select CONTAINER_ID from JX_TX_CONTAINER c where ISPLAN = '0' AND c.CONTAINER_GROUP " +
                    "in (select GROUP_KEY from JX_TX_GROUP g where g.GROUP_BELONG=?)";
            List list = jdbcTemplate.queryForList(sql,params);
            return list;

        }


    }
