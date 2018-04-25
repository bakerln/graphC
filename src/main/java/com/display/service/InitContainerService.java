package com.display.service;

import com.display.model.AreaTest;
import com.display.model.ContainerTest;
import com.display.model.GroupTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LiNan on 2018-04-17.
 * Description:
 */
@Service
public class InitContainerService {


    public List<AreaTest> getArea() {
        AreaTest area1 = new AreaTest();
        area1.setKey("CraneArea");
        area1.setIsGroup(true);
        area1.setCategory("OfGroups");
        area1.setPos("-20 110");
        area1.setSize("1260 10");
        area1.setColor("#333");
        area1.setStroke("rgba(128,128,128,0.4)");

        AreaTest area2 = new AreaTest();
        area2.setKey("CraneArea");
        area2.setIsGroup(true);
        area2.setCategory("OfGroups");
        area2.setPos("-20 540");
        area2.setSize("1260 10");
        area2.setColor("#333");
        area2.setStroke("rgba(128,128,128,0.4)");

        AreaTest area3 = new AreaTest();
        area3.setKey("truckArea");
        area3.setIsGroup(true);
        area3.setCategory("OfGroups");
        area3.setPos("0 0");
        area3.setSize("1220 100");
        area3.setColor("#95c3bf");
        area3.setStroke("rgba(128,128,128,0.4)");

        AreaTest area4 = new AreaTest();
        area4.setKey("BoxArea");
        area4.setIsGroup(true);
        area4.setCategory("OfGroups");
        area4.setPos("0 120");
        area4.setSize("600 420");
        area4.setColor("#9bab88");
        area4.setStroke("rgba(128,128,128,0.4)");

        AreaTest area5 = new AreaTest();
        area5.setKey("trainArea");
        area5.setIsGroup(true);
        area5.setCategory("OfGroups");
        area5.setPos("0 560");
        area5.setSize("1220 60");
        area5.setColor("#758790");
        area5.setStroke("rgba(128,128,128,0.4)");

        List<AreaTest> areaList = new ArrayList<>();
        areaList.add(area1);
        areaList.add(area2);
        areaList.add(area3);
        areaList.add(area4);
        areaList.add(area5);

        return areaList;

    }

    public List<GroupTest> getGroup() {
        GroupTest group1 = new GroupTest();
        group1.setKey("G1");
        group1.setIsGroup(true);
        group1.setGroup("BoxArea");
        group1.setCategory("OfNodes");
        group1.setSize("40 60");
        group1.setPos("0 120");

        GroupTest group2 = new GroupTest();
        group2.setKey("G2");
        group2.setIsGroup(true);
        group2.setGroup("BoxArea");
        group2.setCategory("OfNodes");
        group2.setSize("40 60");
        group2.setPos("50 120");

        GroupTest group3 = new GroupTest();
        group3.setKey("G3");
        group3.setIsGroup(true);
        group3.setGroup("BoxArea");
        group3.setCategory("OfNodes");
        group3.setSize("40 60");
        group3.setPos("0 190");

        GroupTest group4 = new GroupTest();
        group4.setKey("G4");
        group4.setIsGroup(true);
        group4.setGroup("BoxArea");
        group4.setCategory("OfNodes");
        group4.setSize("40 60");
        group4.setPos("0 260");

        GroupTest group5 = new GroupTest();
        group5.setKey("G5");
        group5.setIsGroup(true);
        group5.setGroup("BoxArea");
        group5.setCategory("OfNodes");
        group5.setSize("40 60");
        group5.setPos("0 330");

        List<GroupTest> groupList = new ArrayList<>();
        groupList.add(group1);
        groupList.add(group2);
        groupList.add(group3);
        groupList.add(group4);
        groupList.add(group5);
        return groupList;
    }

    public List<ContainerTest> getContainer() {
        ContainerTest container1 = new ContainerTest();
        container1.setKey("B1");
        container1.setGroup("G1");
        container1.setSize("40 20");
        container1.setLayer(2);
        container1.setPos("0 140");

        ContainerTest container2 = new ContainerTest();
        container2.setKey("B2");
        container2.setGroup("G1");
        container2.setSize("40 20");
        container2.setLayer(1);
        container2.setPos("0 160");

        ContainerTest container3 = new ContainerTest();
        container3.setKey("B3");
        container3.setGroup("G3");
        container3.setSize("40 20");
        container3.setLayer(1);
        container3.setPos("0 300");

        ContainerTest container4 = new ContainerTest();
        container4.setKey("B4");
        container4.setGroup("G4");
        container4.setSize("40 20");
        container4.setLayer(1);
        container4.setPos("0 440");
        List<ContainerTest> containerList = new ArrayList<>();
        containerList.add(container1);
        containerList.add(container2);
        containerList.add(container3);
        containerList.add(container4);

        return containerList;
    }
}
