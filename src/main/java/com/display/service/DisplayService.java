package com.display.service;
import java.util.List;
import com.display.dao.DisplayDao;
import com.display.model.Area;
import com.display.model.Group;
import com.display.model.Container;
import com.display.vo.AreaVO;
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
    public List<Area> getArea () {
        List<Area> areaList = displayDao.getArea();
            return areaList;
    }

    public List<Group> getGroup () {
        List<Group> groupList = displayDao.getGroup();
        return groupList;
    }

    public List<Container> getContainer () {
        List<Container> containerList = displayDao.getContainer();
        return containerList;
    }


}
