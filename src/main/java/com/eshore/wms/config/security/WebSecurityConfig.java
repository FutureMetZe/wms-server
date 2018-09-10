package com.eshore.wms.config.security;

import com.eshore.wms.config.DefaultSetting;
import com.eshore.wms.config.sys.filter.JWTAuthenticationFilter;
import com.eshore.wms.config.sys.filter.JWTLoginFilter;
import com.eshore.wms.config.sys.handler.CustomAccessDeniedHandler;
import com.eshore.wms.config.sys.handler.CustomAuthenticationSuccessHandler;
import com.eshore.wms.config.sys.handler.CustomLogoutSuccessHandler;
import com.eshore.wms.service.impl.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * SpringSecurity的配置
 * 通过SpringSecurity的配置，将JWTLoginFilter，JWTAuthenticationFilter组合在一起
 * @author lizj on 2018/9/03.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    /**
     *  设置 HTTP 验证规则
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LogoutConfigurer<HttpSecurity> httpSecurityLogoutConfigurer = http.cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // 放行配置中的请求
                .antMatchers(DefaultSetting.AUTH_WHITELIST).permitAll()
                // 所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                // 自定义访问失败处理器
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler)
                .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                // 默认注销行为为logout，可以通过下面的方式来修改
                .logout()
                .logoutUrl("/logout")
                // 设置注销成功后跳转页面，默认是跳转到登录页面;
                .logoutSuccessUrl("/user/login")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .permitAll();
    }

    /**
     * 该方法是登录的时候会进入
     * @param auth AuthenticationManagerBuilder
     * @throws Exception e
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService, bCryptPasswordEncoder));
    }
}
