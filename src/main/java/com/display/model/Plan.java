package com.display.model;



/**
 * Created by Ren on 2018-05-09.
 * Description:Plan model
 */
public class Plan {

    private String plan_id;  //计划ID   区域唯一ID（ZT、XT、ZJ、XJ）+（V）
    private String planType;  //计划类别   ZM01:装火车、ZM03:卸火车、ZM05:装集卡、ZM07:卸集卡、ZM09:站内搬移
    private String old_container_id;  //原集装箱ID 每个箱子都有一个计划。生成箱子的时候就生成计划
    private String new_container_id;  //计划集装箱ID
    private String equipment;  //设备编码
    private String planDateEnd;  //计划要求时间   前台输入
    private String planDateBegin;  //计划起始时间   后台生成
    private String createUserID;  //计划创建人
    private String auditorID;  //计划审核人
    private String operatorID;  //实际操作人
    private String operateDate;
    private String planFrom;  //计划来源   图形化生成T，指令输入未转图L1，指令输入已转图L2
    private String flag;  //装卸状态    ZN01:未分配任务、ZN02:已分配任务、ZN03:已完成、ZN04:失败、
    private String heavyFlag;  //空重标识    ZB01: 空、ZB03:重

    public String getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(String plan_id) {
        this.plan_id = plan_id;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
    }

    public String getOld_container_id() {
        return old_container_id;
    }

    public void setOld_container_id(String old_container_id) {
        this.old_container_id = old_container_id;
    }

    public String getNew_container_id() {
        return new_container_id;
    }

    public void setNew_container_id(String new_container_id) {
        this.new_container_id = new_container_id;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPlanDateEnd() {
        return planDateEnd;
    }

    public void setPlanDateEnd(String planDateEnd) {
        this.planDateEnd = planDateEnd;
    }

    public String getPlanDateBegin() {
        return planDateBegin;
    }

    public void setPlanDateBegin(String planDateBegin) {
        this.planDateBegin = planDateBegin;
    }

    public String getCreateUserID() {
        return createUserID;
    }

    public void setCreateUserID(String createUserID) {
        this.createUserID = createUserID;
    }

    public String getAuditorID() {
        return auditorID;
    }

    public void setAuditorID(String auditorID) {
        this.auditorID = auditorID;
    }

    public String getOperatorID() {
        return operatorID;
    }

    public void setOperatorID(String operatorID) {
        this.operatorID = operatorID;
    }

    public String getOperateDate() {
        return operateDate;
    }

    public void setOperateDate(String operateDate) {
        this.operateDate = operateDate;
    }

    public String getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(String planFrom) {
        this.planFrom = planFrom;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getHeavyFlag() {
        return heavyFlag;
    }

    public void setHeavyFlag(String heavyFlag) {
        this.heavyFlag = heavyFlag;
    }
}
