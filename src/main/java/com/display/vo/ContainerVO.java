package com.display.vo;

import java.util.Date;

/**
 * Created by LiNan on 2018-04-26.
 * Description:
 */
public class ContainerVO {
    private String containerID; //集装箱唯一ID
    private String Key;  //元素节点名称B1,B2元素节点名称B1,B2
    private String group;  //箱所在组位置: G1,T1,R1
    private String name;  //箱号
    private String type;  //箱尺寸：20尺，40尺
    private String layer;  //箱所在层数:1\2\3
    private String pos;  //（H B）集装箱位置，用行、贝记录
    private String size;  //（H W）集装箱大小，用实际米数记录
    private String isPlan;  //1计划箱   0实际箱
    private String url;  //集装箱图片

    public String getContainerID() {
        return containerID;
    }

    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIsPlan() {
        return isPlan;
    }

    public void setIsPlan(String isPlan) {
        this.isPlan = isPlan;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
