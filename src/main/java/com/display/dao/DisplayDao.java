package com.display.dao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import com.display.vo.ContainerVO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.display.vo.AreaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import com.config.util.page.PageUtil;




    @Repository
    public class DisplayDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

//        public String getAreaFlag() {
//            String sql = "select * from JX_TX_AREA where FLAG = 1";
//            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(0);
//            return String.valueOf(namedParameterJdbcTemplate.update(sql, paramSource));
//        }



    public List<Area> getArea() {
        String sql = "select * from JX_TX_AREA where FLAG = 1";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
       // SqlParameterSource paramSource = new BeanPropertySqlParameterSource(areaVO);
        List<Area> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Area.class));
        return list;
    }
        public List<Group> getGroup() {
            String sql = "select * from JX_TX_GROUP where FLAG = 1";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            // SqlParameterSource paramSource = new BeanPropertySqlParameterSource(areaVO);
            List<Group> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Group.class));
            return list;
        }

        public List<Container> getContainer() {
            String sql = "select * from JX_TX_CONTAINER ";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            // SqlParameterSource paramSource = new BeanPropertySqlParameterSource(areaVO);
            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
            return list;
        }

        public List<Container> getOldContainerList(HashMap oneVo) {
            String sql = "select * from JX_TX_CONTAINER where CONTAINER_ID:=oldContainerID ";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(oneVo);
            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
            return list;
        }

        public List<Container> getNewContainerList(HashMap oneVo) {
            String sql = "select JX_TX_CONTAINER.* from JX_TX_CONTAINER where JX_TX_CONTAINER.CONTAINER_ID=(select max(JX_TX_PLAN.NEW_CONTAINER_ID) from JX_TX_PLAN where JX_TX_PLAN.OLD_CONTAINER_ID:=oldContainerID) ";
            NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
            SqlParameterSource paramSource = new BeanPropertySqlParameterSource(oneVo);
            List<Container> list = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Container.class));
            if (list!=null&&list.size()!=0){
                return list.get("3");
            }
            return "error";
            return list;
        }

        public ContainerVO getContainerByID(List oldContainerList) {
        }

        public String getNewContainerID(String oldContainerID) {
        }
    }
