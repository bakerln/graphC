package com.display.dao;
import com.display.model.Area;
import com.display.vo.AreaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;



@Repository
public class InitDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public int initArea (Area area){

        String sql = "";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(area);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    //get Area
    public int createID() {
        String sql = "select SEQ_TX_ID.Nextval from dual";
        return jdbcTemplate.queryForObject(sql,Integer.class);
    }

    public String createDate() {
        String sql = "select to_char(sysdate,'yyyyMMddHH24mmss') from dual";
        return jdbcTemplate.queryForObject(sql,String.class);
    }
}
