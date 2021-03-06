package com.display.dao;
import com.display.model.Area;
import com.display.model.Group;
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


    public int addInitArea(Area area) {

        String sql = "INSERT INTO JX_TX_AREA (AREA_ID,AREA_KEY,AREA_SIZE,AREA_POS,AREA_NUM,COLOR,STROKE,AREA_CATEGORY,AREA_ISGROUP,AREA_SCALE,CREATETIME,VERSION,USER_ID,FLAG)" +
                "VALUES(:area_id,:AreaKey,:AreaSize,:AreaPos,:AreaNum,:color,:stroke,:AreaCategory,:area_isGroup,:AreaScale,sysdate,:version,:userID,:flag)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(area);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int updateAreaVersion() {

        String sql ="UPDATE JX_TX_AREA SET FLAG='1' ";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(1 );
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int addInitGroup(Group group) {

        String sql = "INSERT INTO JX_TX_GROUP (GROUP_ID,GROUP_KEY,GROUP_BELONG,GROUP_NAME,CISPOS,GROUP_SIZE,GROUP_POS,GROUP_CATEGORY,GROUP_ISGROUP,GROUP_SCALE,GROUP_URL,CREATETIME,VERSION,USER_ID,FLAG,GROUP_PX_POS)" +
                "VALUES(:group_id,:groupKey,:groupBelong,:groupName,:cisPos,:groupSize,:groupPos,:groupCategory,:group_isGroup,:groupScale,:groupUrl,sysdate,:version,:userID,:flag,:GROUP_PX_POS)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(group);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int updateGroupVersion() {

        String sql ="UPDATE JX_TX_GROUP SET FLAG = '1' ";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(1 );
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
