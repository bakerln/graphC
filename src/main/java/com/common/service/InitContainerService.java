package com.common.service;

import com.common.dao.InitContainerDao;
import com.config.interceptor.ResultMsg;
import com.display.model.Container;
import com.display.model.Group;
import com.display.service.InitService;
import com.plan.dao.PlanDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by LiNan on 2018-05-24.
 * Description:
 */

@Service
public class InitContainerService {

    @Autowired
    private InitContainerDao initContainerDao;
    @Autowired
    private InitService initService;
    @Autowired
    private PlanDao planDao;

    public Group getGroup(String groupName) {
        return initContainerDao.getGroup(groupName);
    }

    public ResultMsg addContainer(Group group, HashMap containerMap) {
        Container container = new Container();
        String containerID = initService.createID("C");
        container.setContainer_id(containerID);

        container.setContainerKey(containerID);
        container.setContainerGroup(group.getGroupKey());
        container.setContainerName((String) containerMap.get("containerKey"));
        container.setContainerType((String) containerMap.get("containerType"));
        container.setLayer((String) containerMap.get("layer"));
        container.setContainerPos(group.getGroupPos());
        //TODO 火车和集卡为相对位置
        container.setGroup_px_pos(group.getGROUP_PX_POS());
        container.setContainerSize((String) containerMap.get("containerSize"));
        container.setIsPlan("0");
        container.setContainerUrl("/images/container-current.png");
        container.setArriveTime("");
        container.setUserID("");

        planDao.addContainer(container);

        return new ResultMsg("","success","");
    }
}
