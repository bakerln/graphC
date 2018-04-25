package com.display.model;

import java.util.Date;

/**
 * Created by Ren on 2018-04-25.
 * Description:
 */

public class Area {
    private String AreaID;  //身份标识
    private String AreaKey;  //区域类别   CraneArea（龙门吊）/ TruckArea（集卡）/BoxArea（箱区）/ TrainArea（火车）
    private String AreaSize;  //  W,H 区域大小,实际米数
    private String AreaPos;  // X,Y  区域位置，实际米数
    private String AreaNum;  // 所含元素
    private String color;  //颜色
    private String stroke; //描边
    private String AreaCategory;  //默认值OfGroups
    private String AreaIsGroup;  //默认值1（True）
    private String AreaScale;  // 展示画面与实际比例，默认0.25
    private Date createTime;  //创建时间
    private Date updateTime;  //修改时间
    private String userID;  //修改人

    public String getAreaID() {
        return AreaID;
    }

    public void setAreaID(String areaID) {
        AreaID = areaID;
    }

    public String getAreaKey() {
        return AreaKey;
    }

    public void setAreaKey(String areaKey) {
        AreaKey = areaKey;
    }

    public String getAreaSize() {
        return AreaSize;
    }

    public void setAreaSize(String areaSize) {
        AreaSize = areaSize;
    }

    public String getAreaPos() {
        return AreaPos;
    }

    public void setAreaPos(String areaPos) {
        AreaPos = areaPos;
    }

    public String getAreaNum() {
        return AreaNum;
    }

    public void setAreaNum(String areaNum) {
        AreaNum = areaNum;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getAreaCategory() {
        return AreaCategory;
    }

    public void setAreaCategory(String areaCategory) {
        AreaCategory = areaCategory;
    }

    public String getAreaIsGroup() {
        return AreaIsGroup;
    }

    public void setAreaIsGroup(String areaIsGroup) {
        AreaIsGroup = areaIsGroup;
    }

    public String getAreaScale() {
        return AreaScale;
    }

    public void setAreaScale(String areaScale) {
        AreaScale = areaScale;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}
