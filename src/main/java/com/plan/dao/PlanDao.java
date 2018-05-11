package com.plan.dao;
import com.display.model.Plan;
import com.display.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;


/**
 * Created by Ren on 2018-05-11.
 * Description:
 */

    @Repository
    public class PlanDao {
        @Autowired
        private JdbcTemplate jdbcTemplate;


    public int addContainer(Container container) {

        String sql = "INSERT INTO JX_TX_CONTAINER (CONTAINER_ID,CONTAINER_KEY,CONTAINER_GROUP,CONTAINER_NAME,CONTAINER_TYPE,LAYER,CONTAINER_POS,CONTAINER_SIZE,ISPLAN,CONTAINER_SCALE,CONTAINER_URL,CREATETIME,UPDATETIME,USER_ID,PLANTIME,ARRIVETIME)" +
                "VALUES(:containerID,:containerKey,:containerGroup,:containerName,:containerType,:layer,:containerPos,:containerSize,:isPlan,:containerScale,:containerUrl,sysdate,sysdate,:userID,:planTime,:arriveTime)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(container);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int addPlan(Plan plan) {

        String sql = "INSERT INTO JX_TX_PLAN (PLAN_ID,PLAN_TYPE,OLD_CONTAINER_ID,NEW_CONTAINER_ID,EQUIPMENT,PLAN_DATE_END,PLAN_DATE_BEGIN,CREATE_USER_ID,AUDITOR_ID,OPERATOR_ID,PLAN_FROM,FLAG,HEAVY_FLAG)" +
                "VALUES(planID,:planType,:oldContainerID,:newContainerID,:equipment,:planDateEnd,:planDateBegin,:createUserID,:auditorID,:operatorID,:planFrom,:flag,:heavyFlag)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(plan);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }


    public int updateOldContainer(String oldPlanID  ){
        String sql = "update JX_TX_CONTAINER set ISPLAN = 3 where ID=(select NEW_CONTAINER_ID from JX_TX_PLAN where ID=? and ISPLAN != 3)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(oldPlanID);
        return namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public int updatePlan(Plan plan){
        String sql = "update JX_TX_PLAN set PLAN_TYPE=:planType,OLD_CONTAINER_ID=:oldContainerID,NEW_CONTAINER_ID=:newContainerID,EQUIPMENT=:equipment,PLAN_DATE_END=:planDateEnd,PLAN_DATE_BEGIN=:planDateBegin,CREATE_USER_ID=:createUserID,AUDITOR_ID=:auditorID,OPERATOR_ID=:operatorID,PLAN_FROM=:planFrom,FLAG=:flag,HEAVY_FLAG=:heavyFlag where PLAN_ID=:planID";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(plan);
        return namedParameterJdbcTemplate.update(sql, paramSource);

    }


    }
