package com.display.service;

import java.util.*;

import com.common.util.CoordinateUtil;
import com.display.dao.DisplayDao;
import com.display.model.*;
import com.display.vo.AreaVO;
import com.display.vo.GroupVO;
import com.display.vo.ContainerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Ren on 2018-05-03.
 * Description: 箱场展示处理
 */


@Service
public class DisplayService {
    @Autowired
    private DisplayDao displayDao;


    //图形展示
    public List<AreaVO> getArea() {
        //得到可用的AreaList(flag==0)
        List<Area> areaList = displayDao.getArea();
        List<AreaVO> showList = new LinkedList();
        if (0 != areaList.size()) {
            for (Object one : areaList) {      //循环取读到的值
                Area area = (Area) one;   //将list中的每一个数组封装成一个VO
                //转换
                String newSize = CoordinateUtil.convertM2P(area.getAreaSize());

                //展示VO
                AreaVO areaVO = new AreaVO();
                areaVO.setID(area.getArea_id());
                areaVO.setKey(area.getAreaKey());

                areaVO.setIsGroup("1".equals(area.getArea_isGroup())?true:false);
                areaVO.setCategory(area.getAreaCategory());
                areaVO.setSize(newSize);
                areaVO.setPos(area.getAreaPos());
                areaVO.setColor(area.getColor());
                areaVO.setNum(area.getAreaNum());
                areaVO.setStroke(area.getStroke());

                showList.add(areaVO);  //重新生成areaList
            }
            return showList;
        } else
            return null;
    }

    public List<GroupVO> getGroup() {
        //得到可用的GroupList(flag==0)
        List<Group> groupList = displayDao.getGroup();
        List<GroupVO> showList = new LinkedList();
        if (0 != groupList.size()) {
            for (Object one : groupList) {   //循环取读到的值
                Group group = (Group) one;   //将list中的每一个数组封装成一个VO
                //转换
                String newSize = CoordinateUtil.convertM2P(group.getGroupSize());

                //展示VO
                GroupVO groupVO = new GroupVO();   //将所有数据封装到新VO中
                groupVO.setId(group.getGroup_id());
                groupVO.setKey(group.getGroupKey());
                groupVO.setIsGroup("1".equals(group.getGroup_isGroup())?true:false);
                groupVO.setGroup(group.getGroupBelong());
                groupVO.setCategory(group.getGroupCategory());
                groupVO.setSize(newSize);
                groupVO.setPos(group.getGROUP_PX_POS());
                groupVO.setName(group.getGroupName());
                groupVO.setCisPos(group.getCisPos());
                groupVO.setGroupPos(group.getGroupPos());

                showList.add(groupVO);    //重新生成groupList
            }
            return showList;
        } else
            return null;
    }

    public List<ContainerVO> getContainer() {
        //得到当前位置的箱子ContainerList (ISPLAN=0)
        List<Container> containerList = displayDao.getContainer();
        List<ContainerVO> showList = new LinkedList();
        for (Container one:containerList) {
            String url = "http://localhost:8001" + one.getContainerUrl();
            //转换
            String newPos = CoordinateUtil.getContainerPos(one.getGroup_px_pos(),one.getLayer());

            //展示VO
            ContainerVO containerVO = new ContainerVO();
            containerVO.setContainerID(one.getContainerID());
            containerVO.setGroup(one.getContainerGroup());
            containerVO.setName(one.getContainerName());
            containerVO.setKey(one.getContainerKey());
            containerVO.setType(one.getContainerType());
            containerVO.setIsPlan(one.getIsPlan());
            containerVO.setLayer(one.getLayer());
            containerVO.setSize(one.getContainerSize());
            containerVO.setPos(newPos);
            containerVO.setUrl(url);
            showList.add(containerVO);
        }
        return showList;
    }


    public ContainerVO getContainerByID(String containerID) {
        //TODO get Container by id
        Container container = displayDao.getContainerByID(containerID);
        //转换MODEL 2 VO
        ContainerVO containerVO = new ContainerVO();   //将所有数据封装到新VO中
        String size = container.getContainerSize();  //进行尺寸的米to坐标的转换
        String newSize = CoordinateUtil.convertM2P(size);
        containerVO.setContainerID(container.getContainerID());
        containerVO.setKey(container.getContainerKey());
        containerVO.setGroup(container.getContainerGroup());
        containerVO.setName(container.getContainerName());
        containerVO.setType(container.getContainerType());
        containerVO.setLayer(container.getLayer());
        containerVO.setPos(container.getContainerPos());
        containerVO.setSize(newSize);
        containerVO.setIsPlan(container.getIsPlan());
        containerVO.setUrl(container.getContainerUrl());

        //TODO return Container
        return containerVO;
    }

    public String getNewContainerID(String oldContainerID) {
        return displayDao.getNewContainerID(oldContainerID);
    }


    //通过areaKey查找所有符合的containeID
    public List getContainerIDList(String areaKey) {
        List ContainerIDList = displayDao.getContainerIDList(areaKey);
        return ContainerIDList;
    }


    //通过旧ID查找newID
    public List getPlanContainerList(List containerIDList) {
        //TODO 通过循环containerIDList取其中的id  并通过getNewID来获取新ID
        List containerNewIDList = new LinkedList();

        for (int i = 0;i < containerIDList.size(); i ++) {
            String oldContainerID = String.valueOf(containerIDList.get(0));
            String newContainerID = getNewContainerID(oldContainerID);
            containerNewIDList.add(newContainerID);
        }

        //  List<Container> containerNewIDList = (List<Container>) displayDao.getNewContainerID(containerIDList);
        return containerNewIDList;
    }


    //通过ID查箱子信息
    public List<ContainerVO> ContainerList(List containerIDList) {
        //TODO 通过固定方法循环取list中的id值去查询箱子信息
        List<ContainerVO> containerList = new LinkedList<ContainerVO>();

        for (int i = 0;i < containerIDList.size(); i ++) {
            // get id
            String containerID = String.valueOf(containerIDList.get(0));
            // use id get Container
            ContainerVO containerVO = getContainerByID(containerID);

            containerList.add(containerVO);
        }
        return containerList;
    }


}
