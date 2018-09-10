package com.eshore.wms.service;

import com.eshore.wms.pojo.User;
import com.eshore.wms.utils.PageUtils;
import com.eshore.wms.utils.WmsResult;

import java.util.List;

/**
 *
 * @author lizj
 * @date 2018/8/29
 */
public interface UserService {
    /**
     * 主键查询
     * @param id id
     * @return User
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 新增
     * @param userEntity 用户实体
     */
    void insert(User userEntity);

    /**
     * 删除用户
     * @param userEntity User
     */
    void del(User userEntity);

    /**
     * 通过登录名得到用户信息
     * @param loginName 登录名
     * @return User
     */
    User getUserEntityByLoginName(String loginName);

    /**
     * 获取user列表
     * @param loginName 登录名
     * @return User
     */
    User getUserByLoginName(String loginName);

    /**
     * 新建用户信息
     * @param userEntity User
     * @return WmsResult
     */
    WmsResult insertUser(User userEntity);

    /**
     * 更新用户信息
     * @param userEntity User
     * @return WmsResult
     */
    WmsResult updateUser(User userEntity);

    /**
     * 删除用户
     * @param groupId ids
     */
    void deleteUsers(List<Integer> groupId);

    /**
     * 分页查询
     * @param name 姓名
     * @param pageSize 分页尺寸
     * @param currentPage 当前页
     * @return PageUtils
     */
    PageUtils<User> getPage(String name, Integer pageSize, Integer currentPage);

    /**
     * 通过id删除用户
     * @param userId userId
     * @return WmsResult
     */
    WmsResult delUserById(Integer userId);

    /**
     * 获取用户角色
     * @param userId userId
     * @return List<Role>
     */
    List<String> getRolesById(Integer userId);

    /**
     * 修改用户角色
     * @param groupId 角色ids
     * @param userId 用户id
     * @return WmsResult
     */
    WmsResult updateRole(List<Integer> groupId, Integer userId);
}
