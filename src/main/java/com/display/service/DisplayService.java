package com.display.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Area> getArea() {
        List<Area> areaList = displayDao.getArea();
        if (0 != areaList.size()) {
            ArrayList<Area> test2 = new ArrayList<>();
            for (Object one : areaList) {      //循环取读到的值
                AreaVO oneVO = (AreaVO) one;   //将list中的每一个数组封装成一个VO
                String size = oneVO.getSize();  //进行尺寸的米to坐标的转换
                String newSize = CoordinateUtil.convertM2P(size);
                String pos = oneVO.getPos();   //进行位置的米to坐标转换
                String newPos = CoordinateUtil.convertM2P(pos);

                AreaVO areaVO = new AreaVO();   //将所有数据封装到新VO中
                areaVO.setColor(oneVO.getColor());
                areaVO.setGroup(oneVO.getGroup());
                areaVO.setKey(oneVO.getKey());
                areaVO.setNum(oneVO.getNum());
                areaVO.setSize(newSize);
                areaVO.setPos(newPos);
                areaVO.setCategory(oneVO.getCategory());
                areaList.add(areaVO);  //重新生成areaList
            }
            return areaList;
        } else return null;
    }

    public List<Group> getGroup() {
        List<Group> groupList = displayDao.getGroup();
        if (0 != groupList.size()) {
            ArrayList<Group> test2 = new ArrayList<>();
            for (Object one : groupList) {   //循环取读到的值
                Group oneVo = (Group) one;   //将list中的每一个数组封装成一个VO
                String size = oneVo.getGroupSize();   //进行尺寸的米to坐标的转换
                String newSize = CoordinateUtil.convertM2P(size);

                GroupVO groupVO = new GroupVO();   //将所有数据封装到新VO中
                groupVO.setId(oneVo.getGroupID());
                groupVO.setKey(oneVo.getGroupKey());
                groupVO.setIsGroup(oneVo.getGroupIsGroup());
                groupVO.setGroup(oneVo.getGroupBelong());
                groupVO.setCategory(oneVo.getGroupCategory());
                groupVO.setSize(newSize);
                groupVO.setPos(oneVo.getGROUP_PX_POS());
                groupVO.setName(oneVo.getGroupName());
                groupVO.setCisPos(oneVo.getCisPos());
                groupVO.setPos(oneVo.getGroupPos());
                groupList.add(groupVO);    //重新生成groupList
            }
            return groupList;
        } else return null;
    }

    public List<Container> getContainer() {
        List<Container> containerList = displayDao.getContainer();
        return containerList;
    }

    public List<Plan> planSingleOld(List oldContainerList){
        ArrayList<Plan> test2 = new ArrayList<>();
        for (Object one : oldContainerList) {
            HashMap oneVo = (HashMap)oldContainerList.get(0);
            String old = (String)oneVo.get("oldContainerID");
            displayDao.getOldContainerList(oneVo);

            ArrayList<Container> test3 = new ArrayList<>();
            Object two = new Object();
            Container twoVO = (Container) two;   //将list中的每一个数组封装成一个VO
            String size = twoVO.getContainerSize();  //进行尺寸的米to坐标的转换
            String newSize = CoordinateUtil.convertM2P(size);


            ContainerVO containerVO = new ContainerVO();   //将所有数据封装到新VO中
            containerVO.setContainerID(twoVO.getContainerID());
            containerVO.setKey(twoVO.getContainerKey());
            containerVO.setGroup(twoVO.getContainerGroup());
            containerVO.setName(twoVO.getContainerName());
            containerVO.setType(twoVO.getContainerType());
            containerVO.setLayer(twoVO.getLayer());
            containerVO.setPos(twoVO.getContainerPos());
            containerVO.setSize(newSize);
            containerVO.setIsPlan(twoVO.getIsPlan());
            containerVO.setUrl(twoVO.getContainerUrl());
            oldContainerList.add(containerVO);  //生成oldContainerList
        }
            return oldContainerList;
    }



    public List<Plan> planSingleNew(List newContainerList){
        ArrayList<Plan> test2 = new ArrayList<>();
        for (Object one : newContainerList) {
            HashMap oneVo = (HashMap) newContainerList.get(0);
            String old = (String) oneVo.get("oldContainerID");
            displayDao.getNewContainerList(oneVo);
            ArrayList<Container> test3 = new ArrayList<>();
            Object two = new Object();
            Container twoVO = (Container) two;   //将list中的每一个数组封装成一个VO
            String size = twoVO.getContainerSize();  //进行尺寸的米to坐标的转换
            String newSize = CoordinateUtil.convertM2P(size);


            ContainerVO containerVO = new ContainerVO();   //将所有数据封装到新VO中
            containerVO.setContainerID(twoVO.getContainerID());
            containerVO.setKey(twoVO.getContainerKey());
            containerVO.setGroup(twoVO.getContainerGroup());
            containerVO.setName(twoVO.getContainerName());
            containerVO.setType(twoVO.getContainerType());
            containerVO.setLayer(twoVO.getLayer());
            containerVO.setPos(twoVO.getContainerPos());
            containerVO.setSize(newSize);
            containerVO.setIsPlan(twoVO.getIsPlan());
            containerVO.setUrl(twoVO.getContainerUrl());
        }
        return newContainerList;
    }

}
