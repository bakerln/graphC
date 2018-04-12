package com.common.interceptor;

/**
 * Created by LiNan on 2018-04-09.
 * Description: 封装返回的结果,把webapi的结果封装返回给webapp
 */
public class ResultMsg {

    private String errorCode;
    private String errorMsg;
    private Object data;

    public ResultMsg(String ErrCode, String ErrMsg, Object data) {
        this.errorCode = ErrCode;
        this.errorMsg = ErrMsg;
        this.data = data;
    }

    public String getErrcode() {
        return errorCode;
    }

    public void setErrcode(String errcode) {
        this.errorCode = errcode;
    }

    public String getErrmsg() {
        return errorMsg;
    }

    public void setErrmsg(String errmsg) {
        this.errorMsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
