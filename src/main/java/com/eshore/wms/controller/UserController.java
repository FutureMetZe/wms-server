package com.eshore.wms.controller;
import com.eshore.wms.pojo.RoleWithBLOBs;
import com.eshore.wms.pojo.User;
import com.eshore.wms.service.RoleService;
import com.eshore.wms.service.UserService;
import com.eshore.wms.utils.PageUtils;
import com.eshore.wms.utils.WmsResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author lizj on 2018/9/03.
 */
@RestController
@RequestMapping("/users")
@Api(value = "用户管理", description = "用户管理")
public class UserController extends BaseController {


    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;



    /**
     * 查询用户权限
     * @return 权限列表
     */
    @ApiOperation(value = "查询用户权限")
    @GetMapping("/authorityList")
    public List<String> authorityList() {
        List<String> authentication = getAuthentication();
        return authentication;
    }

    /**
     * 分页条件查询
     * @param name 姓名
     * @param pageSize 页数量
     * @param currentPage 当前页数
     * @return PageUtils<User>
     */
    @RequestMapping("/page")
    private PageUtils<User> page(String name, Integer pageSize, Integer currentPage) {
        return userService.getPage(name, pageSize, currentPage);
    }

    /**
     * 查询用户
     * @param loginName 登录名
     * @return User
     */
    @GetMapping("/{loginName}")
    public User userGet(@PathVariable String loginName) {
        User userEntity = userService.getUserByLoginName(loginName);
        log.debug("The method is ending");
        return userEntity;
    }

    /**
     * 删除用户
     * @param userId 用户id
     * @return WmsResult
     */
    @RequestMapping("/delete")
    public WmsResult deleteUser(Integer userId) {
        return userService.delUserById(userId);
    }

    /**
     * 更新用户
     * @param user 用户实体
     * @return WmsResult
     */
    @PutMapping("/update")
    public WmsResult update(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 新增用户
     * @param user 用户实体
     * @return WmsResult
     */
    @PutMapping("/add")
    public WmsResult add(@RequestBody User user) {
        return userService.insertUser(user);
    }


    /**
     * 获得用户权限
     * @param userId 用户id
     * @return map
     */
    @GetMapping("/role")
    public Map<String, List> getUserRole(Integer userId) {
        //1.先查询所有权限
        List<RoleWithBLOBs> roles = roleService.allRoles();
        //2.查询用户有那些权限
        List<String> roleNames = userService.getRolesById(userId);
        Map<String, List> map = new HashMap<>();
        map.put("roles", roles);
        map.put("roleNames", roleNames);
        return map;
    }

    /**
     * 批量删除
     * @param groupId ids
     */
    @DeleteMapping("/deletes")
    public void deleteMenus(@RequestBody List<Integer> groupId) {
        userService.deleteUsers(groupId);
    }

    /**
     * 修改用户角色信息
     * @param groupId 权限id
     * @param userId 用户id
     * @return WmsResult
     */
    @PutMapping("/updateRole/{userId}")
    public WmsResult updateRole(@RequestBody List<Integer> groupId, @PathVariable Integer userId) {
        return userService.updateRole(groupId, userId);
    }
}
