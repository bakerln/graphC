package com.display.service;
import com.display.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import com.config.interceptor.ResultMsg;
import com.config.util.session.UserSession;
import com.display.dao.InitDao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.vo.AreaVO;
import com.display.vo.GroupVO;
import com.config.util.date.DateUtil;
import org.springframework.stereotype.Service;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ren on 2018-04-27.
 * Description: 数据业务处理
 */
@Service
public class InitService {

    @Autowired
    private InitDao initDao;



    //初始化箱区


    public void initArea(ArrayList areaList) {

        initDao.deleteAreaOldVersion(); //将旧版本数据置为不可用

        ArrayList<Area> areaListModel = new ArrayList<>();
        for (Object one : areaList) {               //循环从list中取数
            HashMap oneVO = (HashMap) one;  //将每次循环出来的数据封装成一个 oneVO
            //Size坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String size = (String)oneVO.get("size");

            String[] WH = size.split(" ");
            String WI = WH[0];//.replace("(", "");
            String HI = WH[1];//.replace(")", "");
            int W = Integer.parseInt(WI);
            int H = Integer.parseInt(HI);
            int Wm = W / 6;
            int Hm = H / 6;
            String newSize =  Wm + " " + Hm ;

            //pos 坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String pos = (String)oneVO.get("pos");
            String[] XY = pos.split(" ");
            String XI = XY[0];  //.replace("(", "");
            String YI = XY[1];   //.replace(")", "");
            int X = Integer.parseInt(XI);
            int Y = Integer.parseInt(YI);
            int Xm = W / 6;
            int Ym = H / 6;
            String newpos =  Xm + " " + Ym ;

            //将数据封装到model
            Area area = new Area();
            area.setAreaKey((String)oneVO.get(""));
            area.setAreaSize(newSize);
            area.setAreaPos(newpos);
            //  area.setAreaID(getID);     //目前没有方法
            area.setAreaKey((String)oneVO.get("key"));
            area.setAreaNum((String)oneVO.get("num"));
            area.setColor((String)oneVO.get("color"));
            area.setAreaIsGroup((String)oneVO.get("isGroup"));
            area.setAreaCategory((String)oneVO.get("category"));
            area.setStroke("");
            area.setAreaScale("0.25");
            //  area.setCreateTime(DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
            // area.setUserID(session.getUserID);     //目前不涉及到用户
            area.setVersion(DateUtil.dateToString(new Date(),"yyyyMMddHHmmss")); //版本号  14位日期
            area.setFlag("0");

            //
            areaList.add(area);
            initDao.initArea(area);
        }
    }


    //初始化容器
    public void initGroup(ArrayList groupList) {

        initDao.deleteGroupOldVersion();//将旧版本数据置为不可用

        ArrayList<Area> groupListModel = new ArrayList<>();
        for (Object one : groupList) {               //循环从list中取数
            HashMap twoVO = (HashMap) one;  //将每次循环出来的数据封装成一个 oneVO
            //Size坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String size = (String)twoVO.get("size");
            String[] WH = size.split(" ");
            String WI = WH[0];//.replace("(", "");
            String HI = WH[1];//.replace(")", "");
            int W = Integer.parseInt(WI);
            int H = Integer.parseInt(HI);
            int Wm = W / 6;
            int Hm = H / 6;
            String newSize = Wm + " " + Hm ;

//            //pos 坐标转换  px to 米   1尺==2px，1米==3尺==6px
//            String pos = (String)twoVO.get("pos");
//            String[] XY = pos.split(" ");
//            String XI = XY[0];//.replace("(", "");
//            String YI = XY[1];//.replace(")", "");
//            int X = Integer.parseInt(XI);
//            int Y = Integer.parseInt(YI);
//            int Xm = W / 6;
//            int Ym = H / 6;
//            String newpos =  Xm + " " + Ym ;


            Group group = new Group();
            group.setGroupSize(newSize);
            group.setGroupKey("key");
            group.setGroupIsGroup("isGroup");
            group.setGroupBelong("group");
            group.setGroupCategory("category");
            group.setGroupName("name");
            group.setCisPos("cisPos");
            group.setGroupPos("groupPos");
            group.setGROUP_PX_POS("pos");
            //group.set...("pos");
            // group.setGroupID(initDao.getid);  暂无方法
            group.setGroupType("");
            group.setGroupScale("0.25");
            group.setGroupUrl("");
            //group.setCreateTime(DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
            group.setVersion(DateUtil.dateToString(new Date(),"yyyyMMddHHmmss"));
            group.setFlag("0");
            //   group.setUserID(session.getuserid);   //目前不涉及到用户
            groupList.add(group);
            initDao.initGroup(group);
        }
    }

    private String createID(){
        int id = initDao.createID();
        String date = initDao.createDate();
        return date + id;
    }

}
