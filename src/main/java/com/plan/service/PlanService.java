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
    public void addPlan(String containerId, HashMap container1, HashMap plan1){
        //TODO 确定数据格式，并分解数据

        //转换
        String newSize = CoordinateUtil.convertP2M((String) container1.get("size"));
        String newContainerID = initService.createID("C");
        String oleContainerID = containerId;

        //封装Container到model
        Container container = new Container();
        container.setContainer_id(newContainerID);
        container.setContainerKey((String) container1.get("key"));
        container.setContainerGroup((String) container1.get("group"));
        container.setContainerName((String) container1.get("name"));
        container.setContainerType((String) container1.get("type"));
        container.setLayer((String) container1.get("layer"));
        container.setContainerPos((String) container1.get("pos"));
        container.setContainerSize(newSize);
        container.setIsPlan((String) container1.get("isPlan"));
        container.setContainerScale((String) container1.get(""));
        container.setContainerUrl((String) container1.get("url"));
        container.setPlanTime("11");
        container.setArriveTime("22");
        container.setUserID("111");
        planDao.addContainer(container);

        //封装Plan数据到model
        Plan plan = new Plan();
        plan.setPlanID( initService.createID("P"));
        plan.setPlanType((String) plan1.get("planType"));
        plan.setOldContainerID(oleContainerID);
        plan.setNewContainerID(newContainerID);
        plan.setEquipment((String) plan1.get(""));
        plan.setPlanDateEnd((String) plan1.get("planDate"));
        plan.setPlanDateBegin("");
        plan.setCreateUserID("11");
        plan.setAuditorID("22");
        plan.setPlanFrom((String) plan1.get("planFrom"));
        plan.setFlag("ZN02");
        plan.setHeavyFlag((String) plan1.get(""));
        planDao.addPlan(plan);
    }

    //修改计划
    public void updatePlan(String containerId, HashMap container1, HashMap plan1){
        //将原计划箱状态删除
        String oleContainerID = containerId;
        String planID = (String) plan1.get("ID");
        planDao.updateOldContainer(oleContainerID);
        if (null != container1) {
            //转换
            String newSize = CoordinateUtil.convertP2M((String) container1.get("size"));
            //生成新计划箱ID
            String newContainerID = initService.createID("C");

            //封装Container到model
            Container container = new Container();
            container.setContainer_id(newContainerID);
            container.setContainerKey((String) container1.get("key"));
            container.setContainerGroup((String) container1.get("group"));
            container.setContainerName((String) container1.get("name"));
            container.setContainerType((String) container1.get("type"));
            container.setLayer((String) container1.get("layer"));
            container.setContainerPos((String) container1.get("pos"));
            container.setContainerSize(newSize);
            container.setIsPlan((String) container1.get("isPlan"));
            container.setContainerScale((String) container1.get(""));
            container.setContainerUrl((String) container1.get("url"));
            container.setPlanTime("11");
            container.setArriveTime("22");
            container.setUserID("111");
            planDao.addContainer(container);


            Plan plan = new Plan();
            plan.setPlanID( initService.createID("P"));
            plan.setPlanType((String) plan1.get("planType"));
            plan.setOldContainerID(oleContainerID);
            plan.setNewContainerID(newContainerID);
            plan.setEquipment((String) plan1.get(""));
            plan.setPlanDateEnd((String) plan1.get("planDate"));
            plan.setPlanDateBegin("");
            plan.setCreateUserID("11");
            plan.setAuditorID("22");
            plan.setPlanFrom((String) plan1.get("planFrom"));
            plan.setFlag("ZN02");
            plan.setHeavyFlag("");
            planDao.updatePlan(plan);
          } else planDao.deletePlan(planID);
    }






}
