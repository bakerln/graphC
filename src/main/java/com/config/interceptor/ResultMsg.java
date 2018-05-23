package com.config.interceptor;

/**
 * Created by LiNan on 2018-04-09.
 * Description: 封装返回的结果,把webapi的结果封装返回给webapp
 */
public class ResultMsg {

    private String resultCode;
    private String resultMsg;
    private Object data;

    public ResultMsg(String resultCode, String resultMsg, Object data) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.data = data;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
