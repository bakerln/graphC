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
        //得到可用的AreaList(flag==1)
        List<Area> areaList = displayDao.getArea();
        if (0 != areaList.size()) {
            for (Object one : areaList) {      //循环取读到的值
                AreaVO oneVO = (AreaVO) one;   //将list中的每一个数组封装成一个VO
                //转换
                String newSize = CoordinateUtil.convertM2P(oneVO.getSize());
                String newPos = CoordinateUtil.convertM2P(oneVO.getPos());

                //展示VO
                AreaVO areaVO = new AreaVO();
                areaVO.setID(oneVO.getID());
                areaVO.setKey(oneVO.getKey());
                areaVO.setGroup(oneVO.getGroup());
                areaVO.setCategory(oneVO.getCategory());
                areaVO.setSize(newSize);
                areaVO.setPos(newPos);
                areaVO.setColor(oneVO.getColor());
                areaVO.setNum(oneVO.getNum());
                areaVO.setStroke(oneVO.getStroke());

                areaList.add(areaVO);  //重新生成areaList
            }
            return areaList;
        } else
            return null;
    }

    public List<Group> getGroup() {
        List<Group> groupList = displayDao.getGroup();
        if (0 != groupList.size()) {
            for (Object one : groupList) {   //循环取读到的值
                Group oneVO = (Group) one;   //将list中的每一个数组封装成一个VO
                //转换
                String newSize = CoordinateUtil.convertM2P(oneVO.getGroupSize());

                //展示VO
                GroupVO groupVO = new GroupVO();   //将所有数据封装到新VO中
                groupVO.setId(oneVO.getGroupID());
                groupVO.setKey(oneVO.getGroupKey());
                groupVO.setIsGroup(oneVO.getGroupIsGroup());
                groupVO.setGroup(oneVO.getGroupBelong());
                groupVO.setCategory(oneVO.getGroupCategory());
                groupVO.setSize(newSize);
                groupVO.setPos(oneVO.getGROUP_PX_POS());
                groupVO.setName(oneVO.getGroupName());
                groupVO.setCisPos(oneVO.getCisPos());
                groupVO.setGroupPos(oneVO.getGroupPos());

                groupList.add(groupVO);    //重新生成groupList
            }
            return groupList;
        } else
            return null;
    }

    public List<Container> getContainer() {
        List<Container> containerList = displayDao.getContainer();
        return containerList;
    }

//    public ContainerVO planSingleOld(List oldContainerList){
//        //TODO get old Container by id
//        ContainerVO oldContainer = displayDao.getContainerByID(oldContainerList);
//
//
//        //TODO return Container
//
//        return oldContainer;
//        ArrayList<Plan> test2 = new ArrayList<>();
//        for (Object one : oldContainerList) {
//            HashMap oneVo = (HashMap)oldContainerList.get(0);
//            String old = (String)oneVo.get("oldContainerID");
//            List<Container> test3 = displayDao.getOldContainerList(oneVo);
//
//            //
//            Container twoVO = new Container();   //将list中的每一个数组封装成一个VO
//            String size = twoVO.getContainerSize();  //进行尺寸的米to坐标的转换
//            String newSize = CoordinateUtil.convertM2P(size);
//
//
//            ContainerVO containerVO = new ContainerVO();   //将所有数据封装到新VO中
//            containerVO.setContainerID(twoVO.getContainerID());
//            containerVO.setKey(twoVO.getContainerKey());
//            containerVO.setGroup(twoVO.getContainerGroup());
//            containerVO.setName(twoVO.getContainerName());
//            containerVO.setType(twoVO.getContainerType());
//            containerVO.setLayer(twoVO.getLayer());
//            containerVO.setPos(twoVO.getContainerPos());
//            containerVO.setSize(newSize);
//            containerVO.setIsPlan(twoVO.getIsPlan());
//            containerVO.setUrl(twoVO.getContainerUrl());
//            oldContainerList.add(containerVO);  //生成oldContainerList
//        }
//            return containerVO;
//    }



//    public ContainerVO planSingleNew(List newContainerList){
//        ArrayList<Plan> test2 = new ArrayList<>();
//        for (Object one : newContainerList) {
//            HashMap oneVo = (HashMap) newContainerList.get(0);
//            String old = (String) oneVo.get("oldContainerID");
//            displayDao.getNewContainerList(oneVo);
//            ArrayList<Container> test3 = new ArrayList<>();
//            Object two = new Object();
//            Container twoVO = (Container) two;   //将list中的每一个数组封装成一个VO
//            String size = twoVO.getContainerSize();  //进行尺寸的米to坐标的转换
//            String newSize = CoordinateUtil.convertM2P(size);
//
//
//            ContainerVO containerVO = new ContainerVO();   //将所有数据封装到新VO中
//            containerVO.setContainerID(twoVO.getContainerID());
//            containerVO.setKey(twoVO.getContainerKey());
//            containerVO.setGroup(twoVO.getContainerGroup());
//            containerVO.setName(twoVO.getContainerName());
//            containerVO.setType(twoVO.getContainerType());
//            containerVO.setLayer(twoVO.getLayer());
//            containerVO.setPos(twoVO.getContainerPos());
//            containerVO.setSize(newSize);
//            containerVO.setIsPlan(twoVO.getIsPlan());
//            containerVO.setUrl(twoVO.getContainerUrl());
//        }
//        return newContainerList;
//    }

//    public String getNewContainerID(String oldContainerID) {
//        return displayDao.getNewContainerID(oldContainerID);
//    }

//    public ContainerVO getContainerByID(String oldContainerID) {
//        //TODO get old Container by id
////        ContainerVO container = displayDao.getContainerByID(oldContainerID);
//
//
//        //TODO return Container
////        return container;
//    }
}
