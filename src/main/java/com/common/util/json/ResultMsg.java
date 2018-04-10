package com.common.util.json;

/**
 * Created by LiNan on 2018-04-09.
 * Description: 封装返回的结果,把webapi的结果封装返回给webapp
 */
public class ResultMsg {

    private String errcode;
    private String errmsg;
    private Object data;

    public ResultMsg(String ErrCode, String ErrMsg, Object data) {
        this.errcode = ErrCode;
        this.errmsg = ErrMsg;
        this.data = data;
    }

    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
