package com.display.service;

import com.display.model.Area;
import com.display.model.Container;
import com.display.model.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiNan on 2018-04-17.
 * Description:
 */
@Service
public class InitContainerService {


    public List<Area> getArea() {
        Area area1 = new Area();
        area1.setKey("CraneArea");
        area1.setIsGroup(true);
        area1.setCategory("OfGroups");
        area1.setPos("-20 110");
        area1.setSize("1260 10");
        area1.setColor("#333");
        area1.setStroke("rgba(128,128,128,0.4)");

        Area area2 = new Area();
        area2.setKey("CraneArea");
        area2.setIsGroup(true);
        area2.setCategory("OfGroups");
        area2.setPos("-20 540");
        area2.setSize("1260 10");
        area2.setColor("#333");
        area2.setStroke("rgba(128,128,128,0.4)");

        Area area3 = new Area();
        area3.setKey("truckArea");
        area3.setIsGroup(true);
        area3.setCategory("OfGroups");
        area3.setPos("0 0");
        area3.setSize("1220 100");
        area3.setColor("#95c3bf");
        area3.setStroke("rgba(128,128,128,0.4)");

        Area area4 = new Area();
        area4.setKey("BoxArea");
        area4.setIsGroup(true);
        area4.setCategory("OfGroups");
        area4.setPos("0 120");
        area4.setSize("600 420");
        area4.setColor("#9bab88");
        area4.setStroke("rgba(128,128,128,0.4)");

        Area area5 = new Area();
        area5.setKey("trainArea");
        area5.setIsGroup(true);
        area5.setCategory("OfGroups");
        area5.setPos("0 560");
        area5.setSize("1220 60");
        area5.setColor("#758790");
        area5.setStroke("rgba(128,128,128,0.4)");

        List<Area> areaList = new ArrayList<>();
        areaList.add(area1);
        areaList.add(area2);
        areaList.add(area3);
        areaList.add(area4);
        areaList.add(area5);

        return areaList;

    }

    public List<Group> getGroup() {
        Group group1 = new Group();
        group1.setKey("G1");
        group1.setIsGroup(true);
        group1.setGroup("BoxArea");
        group1.setCategory("OfNodes");
        group1.setSize("40 60");
        group1.setPos("0 120");

        Group group2 = new Group();
        group2.setKey("G2");
        group2.setIsGroup(true);
        group2.setGroup("BoxArea");
        group2.setCategory("OfNodes");
        group2.setSize("40 60");
        group2.setPos("50 120");

        Group group3 = new Group();
        group3.setKey("G3");
        group3.setIsGroup(true);
        group3.setGroup("BoxArea");
        group3.setCategory("OfNodes");
        group3.setSize("40 60");
        group3.setPos("0 190");

        Group group4 = new Group();
        group4.setKey("G4");
        group4.setIsGroup(true);
        group4.setGroup("BoxArea");
        group4.setCategory("OfNodes");
        group4.setSize("40 60");
        group4.setPos("0 260");

        Group group5 = new Group();
        group5.setKey("G5");
        group5.setIsGroup(true);
        group5.setGroup("BoxArea");
        group5.setCategory("OfNodes");
        group5.setSize("40 60");
        group5.setPos("0 330");

        List<Group> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        groupList.add(group5);
        return groupList;
    }

    public List<Container> getContainer() {
        Container container1 = new Container();
        container1.setKey("B1");
        container1.setGroup("G1");
        container1.setSize("40 20");
        container1.setLayer(2);
        container1.setPos("0 140");

        Container container2 = new Container();
        container2.setKey("B2");
        container2.setGroup("G1");
        container2.setSize("40 20");
        container2.setLayer(1);
        container2.setPos("0 160");

        Container container3 = new Container();
        container3.setKey("B3");
        container3.setGroup("G3");
        container3.setSize("40 20");
        container3.setLayer(1);
        container3.setPos("0 300");

        Container container4 = new Container();
        container4.setKey("B4");
        container4.setGroup("G4");
        container4.setSize("40 20");
        container4.setLayer(1);
        container4.setPos("0 440");
        List<Container> containerList = new ArrayList<>();
        containerList.add(container1);
        containerList.add(container2);
        containerList.add(container3);
        containerList.add(container4);

        return containerList;
    }
}
