package com.display.vo;

import java.util.Date;

/**
 * Created by LiNan on 2018-04-26.
 * Description:
 */
public class GroupVO {
    private String groupID;  //容器ID
    private String groupKey;  //组节点名称，唯一标识 G表示箱位，T表示集卡，R表示火车，L表示龙门吊
    private String groupType;  //G表示箱位，T表示集卡，R表示火车，L表示龙门吊
    private String groupBelong;  //CraneArea：龙门吊   TruckArea：集卡    BoxArea：箱区   TrainArea：火车  组节点所属区域
    private String groupName;  //车号，集卡号
    private String cisPos;  //顺位号
    private String groupSize;  //车号，集卡号
    private String groupPos;  //（H B）区域位置，用行、贝记录
    private String groupCategory;  //默认值OfNodes
    private String groupIsGroup;  //默认值1 (TRUE)
    private String groupScale;  // 展示画面与实际比例，默认0.25
    private String groupUrl;  //火车和集卡图片
    private String createTime;
    private String updateTime;
    private String userID;

    public String getGroupID() {
        return groupID;
    }

    public void setGroupID(String groupID) {
        this.groupID = groupID;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public String getGroupType() {
        return groupType;
    }

    public void setGroupType(String groupType) {
        this.groupType = groupType;
    }

    public String getGroupBelong() {
        return groupBelong;
    }

    public void setGroupBelong(String groupBelong) {
        this.groupBelong = groupBelong;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getCisPos() {
        return cisPos;
    }

    public void setCisPos(String cisPos) {
        this.cisPos = cisPos;
    }

    public String getGroupSize() {
        return groupSize;
    }

    public void setGroupSize(String groupSize) {
        this.groupSize = groupSize;
    }

    public String getGroupPos() {
        return groupPos;
    }

    public void setGroupPos(String groupPos) {
        this.groupPos = groupPos;
    }

    public String getGroupCategory() {
        return groupCategory;
    }

    public void setGroupCategory(String groupCategory) {
        this.groupCategory = groupCategory;
    }

    public String getGroupIsGroup() {
        return groupIsGroup;
    }

    public void setGroupIsGroup(String groupIsGroup) {
        this.groupIsGroup = groupIsGroup;
    }

    public String getGroupScale() {
        return groupScale;
    }

    public void setGroupScale(String groupScale) {
        this.groupScale = groupScale;
    }

    public String getGroupUrl() {
        return groupUrl;
    }

    public void setGroupUrl(String groupUrl) {
        this.groupUrl = groupUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
