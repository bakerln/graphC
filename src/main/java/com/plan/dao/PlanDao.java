package com.plan.dao;
import com.display.model.Plan;
import com.display.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Ren on 2018-05-11.
 * Description:
 */
    @Repository
    public class PlanDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getPlanID(String oldContainerID) {
        Object[] params = new Object[] { oldContainerID };
        String sql = "select PLAN_ID from JX_TX_PLAN where OLD_CONTAINER_ID = ? and FLAG = 'ZN02'";
        List list = jdbcTemplate.queryForList(sql,params);
        if(list.size()==0){
            return "";
        }else{
            HashMap map = (HashMap)list.get(0);
            return  (String) map.get("PLAN_ID");
        }
    }
    public Plan getPlan(String planContainerID) {
        Object[] params = new Object[] { planContainerID };
        String sql = "select * from JX_TX_PLAN where NEW_CONTAINER_ID = ? and FLAG = 'ZN02'";
        List<Plan> list = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper(Plan.class));
        return list.get(0);
    }

    public int addContainer(Container container) {
        String sql = "INSERT INTO JX_TX_CONTAINER (CONTAINER_ID,CONTAINER_KEY,CONTAINER_GROUP,CONTAINER_NAME,CONTAINER_TYPE,LAYER,CONTAINER_POS,GROUP_PX_POS,CONTAINER_SIZE,ISPLAN,CONTAINER_SCALE,CONTAINER_URL,CREATETIME,UPDATETIME,USER_ID,PLANTIME,ARRIVETIME)" +
                "VALUES(:container_id,:containerKey,:containerGroup,:containerName,:containerType,:layer,:containerPos,:group_px_pos,:containerSize,:isPlan,:containerScale,:containerUrl,sysdate,sysdate,:userID,:planTime,:arriveTime)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(container);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int addPlan(Plan plan) {
        String sql = "INSERT INTO JX_TX_PLAN (PLAN_ID,PLAN_TYPE,OLD_CONTAINER_ID,NEW_CONTAINER_ID,EQUIPMENT,PLAN_DATE_END,PLAN_DATE_BEGIN,CREATE_USER_ID,AUDITOR_ID,OPERATOR_ID,CREATETIME,PLAN_FROM,FLAG,HEAVY_FLAG)" +
                "VALUES(:planID,:planType,:oldContainerID,:newContainerID,:equipment,:planDateEnd,:planDateBegin,:createUserID,:auditorID,:operatorID,sysdate,:planFrom,:flag,:heavyFlag)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(plan);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int updatePlanContainer(String Container_ID){
        Object[] params = new Object[] { Container_ID };
        String sql = "update JX_TX_CONTAINER set ISPLAN = '3' ,UPDATETIME = sysdate where CONTAINER_ID = ?";
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(params);
        return jdbcTemplate.update(sql, params);
    }

    public int updatePlan(Plan plan){
        String sql = "update JX_TX_PLAN set PLAN_TYPE=:planType,OLD_CONTAINER_ID=:old_container_id,NEW_CONTAINER_ID=:new_container_id,EQUIPMENT=:equipment," +
                "PLAN_DATE_END=:planDateEnd,PLAN_DATE_BEGIN=:planDateBegin,CREATE_USER_ID=:createUserID,AUDITOR_ID=:auditorID,OPERATOR_ID=:operatorID,UPDATETIME=sysdate," +
                "PLAN_FROM=:planFrom,FLAG=:flag,HEAVY_FLAG=:heavyFlag where PLAN_ID=:plan_id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(plan);
        return namedParameterJdbcTemplate.update(sql, paramSource);

    }

    public int deletePlan(String planID){
        String sql = "update JX_TX_PLAN set FLAG='ZN05'  where PLAN_ID=?";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(planID);
        return namedParameterJdbcTemplate.update(sql, paramSource);

    }



}
