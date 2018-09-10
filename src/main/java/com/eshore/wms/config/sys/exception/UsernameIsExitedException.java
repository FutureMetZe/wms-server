package com.eshore.wms.config.sys.exception;

/**
 * @author lizj on 2018/9/03.
 */
public class UsernameIsExitedException extends BaseException {

    public UsernameIsExitedException(String msg) {
        super(msg);
    }

    public UsernameIsExitedException(String msg, Throwable t) {
        super(msg, t);
    }
}