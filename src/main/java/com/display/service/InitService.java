package com.display.service;
import org.springframework.beans.factory.annotation.Autowired;
import com.config.interceptor.ResultMsg;
import com.config.util.session.UserSession;
import com.display.dao.InitDao;
import com.display.model.Area;
import com.display.vo.AreaVO;
import com.config.util.date.DateUtil;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InitService {

    @Autowired
    private InitDao initDao;

//    public ResultMsg initArea(AreaVO areaVO, Area area) {

//        AreaList areaList = new AreaList();
//        for (HashMap key : area) ;
//         key.get("");
//         area.setStroke("OfGroups");
//         area.setAreaScale("0.25");
//         area.setCreateTime(DateUtil.dateToString(new Date(), "yyyy-MM-dd"));
//         area.setFlag("1");
//         area.setVersion("");
//
//         area.setAreaSize(String.valueOf(areaVO.getSize()));
//         area.setAreaKey(String.valueOf(areaVO.getKey()));
//         area.setAreaPos(String.valueOf(areaVO.getPos()));
//         area.setAreaNum(String.valueOf(areaVO.getNum()));
//         area.setColor(String.valueOf(areaVO.getColor()));
//         area.setAreaIsGroup(String.valueOf(areaVO.getGroup()));
//         area.setAreaCategory(String.valueOf(areaVO.getCategory()));
//
//        initDao.initArea(area);
//        return null;
//    }





    public void initArea(ArrayList VOlist) {
        ArrayList<Area> areaList = new ArrayList<>();
        for (Object one:VOlist) {               //循环从list中取数
            AreaVO oneVO = (AreaVO)one;  //将每次循环出来的数据封装成一个 oneVO
            //Size坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String size = oneVO.getSize();
            String[] WH = size.split(" ");
            String WI = WH[0].replace("(","");
            String HI = WH[1].replace(")","");
            int W = Integer.parseInt(WI);
            int H = Integer.parseInt(HI);
            int Wm = W / 6;
            int Hm = H / 6;
            String newSize = "(" + Wm + " " + Hm + ")";

            //pos 坐标转换  px to 米   1尺==2px，1米==3尺==6px
            String pos = oneVO.getPos();
            String[] XY = pos.split(" ");
            String XI = XY[0].replace("(","");
            String YI = XY[1].replace(")","");
            int X = Integer.parseInt(XI);
            int Y = Integer.parseInt(YI);
            int Xm = W / 6;
            int Ym = H / 6;
            String newpos = "(" + Xm + " " + Ym + ")";

            //将VO数据封装到model
            Area area = new Area();
            area.setAreaKey(oneVO.getKey());
            area.setAreaSize(newSize);
            area.setAreaPos(newpos);

            areaList.add(area);

        }
    }


    public void initGroup(ArrayList testList) {
    }
}
