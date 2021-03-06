package com.display.service;

import java.util.*;
import com.common.util.CoordinateUtil;
import com.config.util.global.GlobalConst;
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

    /**
     * 获得区域列表
     * @return
     */
    public List<AreaVO> getAreaList() {
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

    /**
     * 获得容器列表
     * @return
     */
    public List<GroupVO> getGroupList() {
        //得到可用的GroupList(flag==0)
        List<Group> groupList = displayDao.getGroup();
        List<GroupVO> showList = new LinkedList();
        if (0 != groupList.size()) {
            for (Object one : groupList) {   //循环取读到的值
                Group group = (Group) one;
                //展示VO
                GroupVO groupVO = new GroupVO();
                //箱区单位转换
                if("OfNodes".equals(group.getGroupCategory())){
                    String newSize = CoordinateUtil.convertM2P(group.getGroupSize());
                    groupVO.setSize(newSize);
                }else{
                    groupVO.setSize(group.getGroupSize());
                }
                groupVO.setId(group.getGroup_id());
                groupVO.setKey(group.getGroupKey());
                groupVO.setIsGroup("1".equals(group.getGroup_isGroup())?true:false);
                groupVO.setGroup(group.getGroupBelong());
                groupVO.setCategory(group.getGroupCategory());
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

    /**
     *  获得集装箱列表
     * @return
     */
    public List<ContainerVO> getContainerList() {
        //得到当前位置的箱子ContainerList (ISPLAN=0)
        List<Container> containerList = displayDao.getContainer();
        List<ContainerVO> showList = new LinkedList();
        for (Container one:containerList) {
            String url =  GlobalConst.PIC_URL + one.getContainerUrl();
            //转换
            String newPos = CoordinateUtil.getContainerPos(one.getGroup_px_pos(),one.getLayer());

            //展示VO
            ContainerVO containerVO = new ContainerVO();
            containerVO.setContainerID(one.getContainer_id());
            containerVO.setGroup(one.getContainerGroup());
            containerVO.setName(one.getContainerName());
            containerVO.setKey(one.getContainerKey());
            containerVO.setType(one.getContainerType());
            containerVO.setIsPlan(one.getIsPlan());
            containerVO.setLayer(Integer.valueOf(one.getLayer()));
            containerVO.setSize(one.getContainerSize());
            containerVO.setPos(newPos);
            containerVO.setUrl(url);

            showList.add(containerVO);
        }
        return showList;
    }

    /**
     * 获得单个集装箱
     * @param param 参数
     * @param type  类型 "id":1 、"name":2
     * @return
     */
    public ContainerVO getContainer(String param,String type){
        Container container;
        if ("2".equals(type)){
            //通过isplan = 0 定位具体箱子
            container = displayDao.getContainerByName(param);
        }else if ("1".equals(type)){
            container = displayDao.getContainerByID(param);
        }else return null;

        //该箱场无箱子显示null
        if (container == null) return null;

        //转换
        String newPos = CoordinateUtil.getContainerPos(container.getGroup_px_pos(),container.getLayer());
        String url = GlobalConst.PIC_URL + container.getContainerUrl();

        //展示VO
        ContainerVO containerVO = new ContainerVO();
        containerVO.setContainerID(container.getContainer_id());
        containerVO.setKey(container.getContainerKey());
        containerVO.setGroup(container.getContainerGroup());
        containerVO.setName(container.getContainerName());
        containerVO.setType(container.getContainerType());
        containerVO.setLayer(Integer.valueOf(container.getLayer()));
        containerVO.setPos(newPos);
        containerVO.setSize(container.getContainerSize());
        containerVO.setIsPlan(container.getIsPlan());
        containerVO.setUrl(url);

        return containerVO;
    }


    /**
     * 通过Plan获得计划箱ID
     * @param oldContainerName
     * @return
     */
    public String getPlanContainerIDbyName(String oldContainerName) {
        Container oldContainer = displayDao.getContainerByName(oldContainerName);
        //箱场有无该箱子
        if (oldContainer == null) return "";
        return displayDao.getPlanContainerID(oldContainer.getContainer_id());
    }

    /**
     * 通过areaKey查找所有符合的containeID
     * @param areaKey
     * @return
     */
    public List getContainerIDList(String areaKey) {
        List ContainerIDList = displayDao.getContainerIDList(areaKey);
        return ContainerIDList;
    }


    /**
     * 通过currentID查找PlanID
     * @param containerIDList
     * @return
     */
    public List getPlanContainerList(List containerIDList) {
        //TODO 通过循环containerIDList取其中的id  并通过getNewID来获取新ID
        List containerNewIDList = new LinkedList();
        for (Object one:containerIDList) {
            HashMap map = new HashMap<>();
            HashMap containerID = (HashMap)one;
            String containerPlanID = displayDao.getPlanContainerID((String)containerID.get("container_id"));
            if ("".equals(containerPlanID)){
                continue;
            }
            map.put("CONTAINER_ID",containerPlanID);
            containerNewIDList.add(map);
        }
        return containerNewIDList;
    }


    //通过ID查箱子信息
    public List<ContainerVO> ContainerList(List containerIDList) {
        //TODO 通过固定方法循环取list中的id值去查询箱子信息
        List<ContainerVO> containerList = new LinkedList<ContainerVO>();

        for (Object one:containerIDList) {
            HashMap map = (HashMap) one;
            String containerID = (String) map.get("CONTAINER_ID");
            ContainerVO containerVO = getContainer(containerID,"1");
            containerList.add(containerVO);
        }

        return containerList;
    }



}
