package com.eshore.wms.utils;

import java.io.Serializable;

/**
 * Created by lizj on 2018/9/4.
 */
public class WmsResult implements Serializable {



    private Boolean success;
    private String msg;
    private Object obj;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public WmsResult(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public static WmsResult success(String msg) {
        return new WmsResult(true,msg);
    }

    public static WmsResult fail(String msg) {
        return new WmsResult(false,msg);
    }
}
