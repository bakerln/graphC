package com.display.model;

import java.util.Date;

/**
 * Created by Ren on 2018-04-25.
 * Description:
 */

public class Area {
    private String area_id;  //身份标识
    private String AreaKey;  //区域类别   CraneArea（龙门吊）/ TruckArea（集卡）/BoxArea（箱区）/ TrainArea（火车）
    private String AreaSize;  //  W,H 区域大小,实际米数
    private String AreaPos;  // X,Y  区域位置，实际米数
    private String AreaNum;  // 所含元素
    private String color;  //颜色
    private String stroke; //描边
    private String AreaCategory;  //默认值OfiGroups
    private String area_isGroup;  //默认值1（True）
    private String AreaScale;  // 展示画面与实际比例，默认0.25
    private Date createTime;  //创建时间
    private String userID;  //修改人
    private String version;  //版本号
    private String flag;  //1：区域不可用  0：区域可用


    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getArea_isGroup() {
        return area_isGroup;
    }

    public void setArea_isGroup(String area_isGroup) {
        this.area_isGroup = area_isGroup;
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }



    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}


