package com.display.model;


import java.util.Date;

/**
 * Created by Ren on 2018-04-25.
 * Description:
 */


public class Container {
    private String containerID; //集装箱唯一ID
    private String containerKey;  //元素节点名称B1,B2元素节点名称B1,B2
    private String containerGroup;  //箱所在组位置: G1,T1,R1
    private String containerName;  //箱号
    private String containerType;  //箱尺寸：20尺，40尺
    private String layer;  //箱所在层数:1\2\3
    private String containerPos;  //（H B）集装箱位置，用行、贝记录
    private String containerSize;  //（H W）集装箱大小，用实际米数记录
    private String isPlan;  //1计划箱   0实际箱
    private String containerScale;  // 展示画面与实际比例，默认0.25
    private String containerUrl;  //集装箱图片
    private Date createTime;
    private Date updateTime;
    private String userID;

    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getContainerKey() {
        return containerKey;
    }

    public void setContainerKey(String containerKey) {
        this.containerKey = containerKey;
    }

    public String getContainerGroup() {
        return containerGroup;
    }

    public void setContainerGroup(String containerGroup) {
        this.containerGroup = containerGroup;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getContainerPos() {
        return containerPos;
    }

    public void setContainerPos(String containerPos) {
        this.containerPos = containerPos;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(String isPlan) {
        this.isPlan = isPlan;
    }

    public String getContainerScale() {
        return containerScale;
    }

    public void setContainerScale(String containerScale) {
        this.containerScale = containerScale;
    }

    public String getContainerUrl() {
        return containerUrl;
    }

    public void setContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
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
