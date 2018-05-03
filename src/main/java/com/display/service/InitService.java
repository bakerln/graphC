package com.display.service;
import com.display.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import com.display.dao.InitDao;
import com.display.model.Area;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.common.util.CoordinateUtil;

/**
 * Created by Ren on 2018-04-27.
 * Description: 数据业务处理
 */
@Service
public class InitService {

    @Autowired
    private InitDao initDao;

    //初始化箱区
    public void addInitArea(List areaList) {

        initDao.deleteAreaOldVersion(); //将旧版本数据置为不可用

        ArrayList<Area> test2 = new ArrayList<>();
        for (Object one : areaList) {               //循环从list中取数
            HashMap oneVO = (HashMap) areaList.get(0);  //将每次循环出来的数据封装成一个 oneVO
            String size = (String) oneVO.get("size"); //size坐标转换
            String newSize = CoordinateUtil.convertP2M(size);
            String pos = (String) oneVO.get("pos");  //pos坐标转换
            String newpos = CoordinateUtil.convertP2M(pos);

            //将数据封装到model
            Area area = new Area();
            area.setAreaKey((String) oneVO.get(""));
            area.setAreaSize(newSize);
            area.setAreaPos(newpos);
            area.setAreaID(createID());
            area.setAreaKey((String) oneVO.get("key"));
            area.setAreaNum((String) oneVO.get("num"));
            area.setColor((String) oneVO.get("color"));
            area.setAreaIsGroup("1");
            area.setAreaCategory((String) oneVO.get("category"));
            area.setStroke("");
            area.setAreaScale("0.25");
            area.setUserID("");
            area.setAreaNum("4");
            area.setVersion(initDao.createDate()); //版本号  14位日期
            area.setFlag("0");
            areaList.add(area);
            initDao.addInitArea(area);
        }
    }


    //初始化容器
    public void addInitGroup(List groupList) {

        initDao.deleteGroupOldVersion();//将旧版本数据置为不可用

        ArrayList<Group> groupListModel = new ArrayList<>();
        for (Object two : groupList) {//循环从list中取数
            HashMap twoVO = (HashMap) groupList.get(0);  //将每次循环出来的数据封装成一个 oneVO
            //Size坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String size = (String)twoVO.get("size");
            String newSize = CoordinateUtil.convertP2M(size) ;
            Group group = new Group();
            group.setGroupSize(newSize);
            group.setGroupKey((String) twoVO.get("key"));
            group.setGroupIsGroup("1");
            group.setGroupBelong((String) twoVO.get("group"));
            group.setGroupCategory((String) twoVO.get("category"));
            group.setGroupName((String) twoVO.get("name"));
            group.setCisPos((String) twoVO.get("cisPos"));
            group.setGroupPos((String) twoVO.get("groupPos"));
            group.setGROUP_PX_POS((String) twoVO.get("pos"));
            group.setGroupID(createID());
            group.setGroupType("");
            group.setGroupScale("0.25");
            group.setGroupUrl("");
            group.setVersion(initDao.createDate());
            group.setFlag("0");
            groupList.add(group);
            group.setUserID("");
            group.setCisPos("");
            group.setGroupName("");
            group.setGroupPos("");
            initDao.addInitGroup(group);
        }
    }

    private String createID(){
        int id = initDao.createID();
        String date = initDao.createDate();
        return date + id;
    }

}
