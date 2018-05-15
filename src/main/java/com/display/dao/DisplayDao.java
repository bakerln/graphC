package com.display.dao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
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
            //
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
            String sql = "select NEW_CONTAINER_ID from JX_TX_PLAN where OLD_CONTAINER_ID = ?";
            return jdbcTemplate.queryForObject(sql,params,String.class);

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
