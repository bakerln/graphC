package com.display.dao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;




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
            String sql = "select * from JX_TX_CONTAINER ";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
            return list;
        }

//        public List<Container> getOldContainerList(HashMap oneVo) {
//            String sql = "select * from JX_TX_CONTAINER where CONTAINER_ID:=oldContainerID ";
//            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(oneVo);
//            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
//            return list;
//        }
//
//        public List<Container> getNewContainerList(HashMap oneVo) {
//            String sql = "select JX_TX_CONTAINER.* from JX_TX_CONTAINER where JX_TX_CONTAINER.CONTAINER_ID=(select max(JX_TX_PLAN.NEW_CONTAINER_ID) from JX_TX_PLAN where JX_TX_PLAN.OLD_CONTAINER_ID:=oldContainerID) ";
//            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(oneVo);
//            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
//            if (list!=null&&list.size()!=0){
//            }
//            return list;
//        }

        public Container getContainerByID(String containerID) {
            Object[] params = new Object[] { containerID };
            String sql = "select * from JX_TX_CONTAINER where ID=?";
            List<Container> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Container.class));
            return list.get(0);
        }

        public String getNewContainerID(String oldContainerID) {
            Object[] params = new Object[] { oldContainerID };
            String sql = "select NEW_CONTAINER_ID from JX_TX_PLAN where ID=?";
            List<Container> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Container.class));
            return String.valueOf(list.get(0));

        }

        public List<Container> getContainerIDList(String areaKey) {
            Object[] params = new Object[] { areaKey };
            String sql = "select CONTAINER_ID from JX_TX_CONTAINER c where c.CONTAINER_GROUP\n" +
                    "in (select GROUP_KEY from JX_TX_GROUP g where g.GROUP_BELONG=?)";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            // SqlParameterSource paramSource = new BeanPropertySqlParameterSource(areaVO);
            List<Container> list = namedParameterJdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Container.class));
            return list;

        }
    }
