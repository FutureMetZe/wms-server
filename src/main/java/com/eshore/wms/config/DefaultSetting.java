package com.eshore.wms.config;

/**
 * 默认配置类
 * @author lizj
 * @date 2018/9/4
 */
public final class DefaultSetting {

    private DefaultSetting() {
    }

    /**
     * 需要放行的URL
     */
    public static final String[] AUTH_WHITELIST = {
            "/users/signup",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
    };

    /**
     * 配置过期时间(这里为了方便测试设置了10天的过期时间)
     */
    private static final Integer EXPIRATION_TIME = 10 * 24 * 60 * 60 * 1000;

    public static Long getExpirationTime() {
        return System.currentTimeMillis() + EXPIRATION_TIME;
    }


}
