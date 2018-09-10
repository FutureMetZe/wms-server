package com.eshore.wms.config.sys.exception;

/**
 * 描述：
 *  * <p>
 *
 * @author: lizj
 * @date: 2018/4/11 23:06
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}

