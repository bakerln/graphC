package com.display.vo;

import com.display.model.Group;

import java.util.Date;

/**
 * Created by LiNan on 2018-04-26.
 * Description:
 */
public class GroupVO extends Group {
    private String key;  //组节点名称，唯一标识 G表示箱位，T表示集卡，R表示火车，L表示龙门吊
    private String type;  //G表示箱位，T表示集卡，R表示火车，L表示龙门吊
    private String group;  //CraneArea：龙门吊   TruckArea：集卡    BoxArea：箱区   TrainArea：火车  组节点所属区域
    private String name;  //车号，集卡号
    private String cisPos;  //顺位号
    private String size;  //车号，集卡号
    private String groupPos;  //（H B）区域位置，用行、贝记录
    private String category;  //默认值OfNodes
    private String isGroup;  //默认值1 (TRUE)
    private String pos;
    private String id;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCisPos() {
        return cisPos;
    }

    public void setCisPos(String cisPos) {
        this.cisPos = cisPos;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGroupPos() {
        return groupPos;
    }

    public void setGroupPos(String groupPos) {
        this.groupPos = groupPos;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(String isGroup) {
        this.isGroup = isGroup;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

