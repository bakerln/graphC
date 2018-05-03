package com.display.vo;

import java.util.Date;

/**
 * Created by LiNan on 2018-04-25.
 * Description:
 */
public class AreaVO {
        private String key;  //区域类别   CraneArea（龙门吊）/ TruckArea（集卡）/BoxArea（箱区）/ TrainArea（火车）
        private String name; //名称
        private String size;  //  W,H 区域大小,实际米数
        private String pos;  // X,Y  区域位置，实际米数
        private String num;  // 所含元素
        private String color;  //颜色
        private Boolean isGroup;  //默认值1（True）
        private String category;  //区域类型
        private String stroke;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStroke() {
        return stroke;
    }

    public void setStroke(String stroke) {
        this.stroke = stroke;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getGroup() {
        return isGroup;
    }

    public void setGroup(Boolean group) {
        isGroup = group;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
