package com.plan.service;
import com.common.util.CoordinateUtil;
import com.display.model.Container;
import com.display.model.Group;
import com.display.model.Plan;
import com.display.service.InitService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.plan.dao.PlanDao;

import java.util.HashMap;
import java.util.List;

/**
 * Created by LiNan on 2018-05-10.
 * Description:
 */
@Service
public class PlanService {

    @Autowired
    private PlanDao planDao;
    @Autowired
    private InitService initService;

    //存入计划箱
    public void addPlan(String oldContainerID, HashMap planContainer, HashMap planMap){
        //转换
        String newContainerID = initService.createID("C");

        //封装Container到model
        Container container = new Container();
        container.setContainer_id(newContainerID);
        container.setContainerKey(newContainerID);
        container.setContainerGroup((String) planContainer.get("group"));
        container.setContainerName((String) planContainer.get("name"));
        container.setContainerType((String) planContainer.get("type"));
        container.setLayer(planContainer.get("layer").toString());
        container.setContainerPos((String) planContainer.get("pos"));
        container.setContainerSize((String) planContainer.get("size"));
        container.setIsPlan("1");
        container.setContainerUrl("/images/container-plan.png");
        container.setPlanTime((String) planMap.get("planDate"));
        container.setArriveTime("");
        container.setUserID("");
        planDao.addContainer(container);

        //封装Plan数据到model
        Plan plan = new Plan();
        plan.setPlan_id( initService.createID("P"));
        plan.setPlanType((String) planMap.get("planType"));
        plan.setOld_container_id(oldContainerID);
        plan.setNew_container_id(newContainerID);
        plan.setEquipment((String) planMap.get("equipment"));
        plan.setPlanDateEnd((String) planMap.get("planDate"));
        //TODO 推送到计划执行表时更新
        plan.setPlanDateBegin("");
        plan.setCreateUserID("");
        plan.setAuditorID("");
        plan.setPlanFrom((String) planMap.get("planFrom"));
        plan.setFlag("ZN02");
        plan.setHeavyFlag((String) planMap.get(""));
        planDao.addPlan(plan);
    }

    //修改计划
    public void updatePlan(String planContainerID, HashMap planContainer, HashMap planMap){
        //将原计划箱状态删除
        planDao.updatePlanContainer(planContainerID);



        //生成新计划箱ID
        String newContainerID = initService.createID("C");

        //封装Container到model
        Container container = new Container();
        container.setContainer_id(newContainerID);
        container.setContainerKey(newContainerID);
        container.setContainerGroup((String) planContainer.get("group"));
        container.setContainerName((String) planContainer.get("name"));
        container.setContainerType((String) planContainer.get("type"));
        container.setLayer(planContainer.get("layer").toString());
        container.setContainerPos((String) planContainer.get("pos"));
        container.setContainerSize((String) planContainer.get("size"));
        container.setIsPlan("1");
        container.setContainerUrl("/images/container-plan.png");
        container.setPlanTime((String) planMap.get("planDate"));
        container.setArriveTime("");
        container.setUserID("");
        planDao.addContainer(container);

        //封装Plan数据到model
        Plan oldPlan = planDao.getPlan(planContainerID);
        oldPlan.setPlanType((String) planMap.get("planType"));
        oldPlan.setNew_container_id(newContainerID);
        oldPlan.setEquipment((String) planMap.get("equipment"));
        oldPlan.setPlanDateEnd((String) planMap.get("planDate"));
        //TODO 推送到计划执行表时更新
        oldPlan.setPlanDateBegin("");
        oldPlan.setCreateUserID("");
        oldPlan.setAuditorID("");
        oldPlan.setPlanFrom((String) planMap.get("planFrom"));
        oldPlan.setFlag("ZN02");
        oldPlan.setHeavyFlag((String) planMap.get(""));
        planDao.updatePlan(oldPlan);
    }
}
