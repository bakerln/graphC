package com.display.service;
import com.display.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import com.display.dao.InitDao;
import com.display.model.Area;
import org.springframework.stereotype.Service;
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
    public void addInitArea(List areaVOList, String version) {

        initDao.updateAreaVersion(); //将旧版本数据置为不可用
        //保存
        for (Object one : areaVOList) {               //循环从list中取数
            HashMap oneVO = (HashMap) one;  //将每次循环出来的数据封装成一个 oneVO
             //转换
            String newSize = CoordinateUtil.convertP2M((String) oneVO.get("size"));

            //将数据封装到model
            Area area = new Area();
            area.setArea_id(createID("A"));
            area.setAreaKey((String) oneVO.get("key"));
            area.setAreaSize(newSize);
            area.setAreaPos((String) oneVO.get("pos"));
            area.setAreaNum((String) oneVO.get("num"));
            area.setColor((String) oneVO.get("color"));
            area.setStroke((String) oneVO.get("stroke"));
            area.setAreaCategory((String) oneVO.get("category"));
            area.setArea_isGroup("1");
            area.setAreaScale("0.25");
            area.setVersion(version); //版本号  14位日期
            area.setFlag("0");
            area.setUserID("");
            area.setAreaNum("4");

            //入库
            initDao.addInitArea(area);
        }

    }


    //初始化容器
    public void addInitGroup(List groupList, String version) {

        initDao.updateGroupVersion();//将旧版本数据置为不可用

        for (Object one : groupList) {//循环从list中取数
            HashMap oneVO = (HashMap) one;  //将每次循环出来的数据封装成一个 oneVO
            //转换  px to 米   1尺==2px，1米==3尺==6px
            String newSize = CoordinateUtil.convertP2M((String)oneVO.get("size")) ;

            //将数据封装到model
            Group group = new Group();
            group.setGroup_id(createID("G"));
            group.setGroupKey((String) oneVO.get("key"));
            group.setGroupCategory((String) oneVO.get("category"));
            group.setGroupBelong((String) oneVO.get("group"));
            group.setGroupName((String) oneVO.get("name"));
            group.setCisPos((String) oneVO.get("cisPos"));
            group.setGroupSize(newSize);
            group.setGROUP_PX_POS((String) oneVO.get("pos"));
            group.setGroupPos((String) oneVO.get("groupPos"));
            group.setGroup_isGroup("1");
            group.setGroupScale("0.25");
            group.setGroupUrl("");
            group.setVersion(version);
            group.setFlag("0");
            group.setUserID("");

            initDao.addInitGroup(group);
        }
    }

    public String getVersion(){
        return initDao.createDate();
    }

    /**
     *
     * @param flag id属性，Area:A /Group:G/ Container:C
     * @return
     */
    private String createID(String flag){
        int id = initDao.createID();
        String date = initDao.createDate();
        return flag + date + id;
    }
}
