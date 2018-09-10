package com.eshore.wms.controller;

import com.eshore.wms.pojo.User;

import com.eshore.wms.utils.WmsResult;
import io.swagger.annotations.Api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizj on 2018/08/31.
 */
@RestController
@RequestMapping("/users")
@Api(value = "注册管理", description = "注册管理")
public class RegisterController extends BaseController {

    /**
     * 注册用户 默认开启白名单
     * @param user
     */
    @PostMapping("/signup")
    public WmsResult signup(@RequestBody User user) {
        User bizUser = userMapper.getUserByLoginName(user.getUsername());
        if(null != bizUser){
            return WmsResult.fail("用户已经存在！");
        }
        /*user.setPassword(DigestUtils.md5DigestAsHex((user.getPassword()).getBytes()));*/
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if(userMapper.insert(user)>0){
            return WmsResult.success("操作成功！");
        } else {
            return WmsResult.fail("操作失败！");
        }
    }

}
