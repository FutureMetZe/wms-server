package com.eshore.wms.utils;

/**
 * Created by lizj on 2018/9/3.
 */
public class SimpleResponse {
	public static final int SUCCESS = 0;
	public static final int FAIL = 1;
    private Object content;
    private int status;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
}
