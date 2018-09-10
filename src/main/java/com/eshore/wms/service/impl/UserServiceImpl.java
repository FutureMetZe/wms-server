package com.eshore.wms.service.impl;

import com.eshore.wms.dao.RoleMapper;
import com.eshore.wms.dao.UserMapper;
import com.eshore.wms.dao.UserRoleMapper;
import com.eshore.wms.pojo.User;
import com.eshore.wms.pojo.UserRole;
import com.eshore.wms.service.UserService;
import com.eshore.wms.utils.PageUtils;
import com.eshore.wms.utils.WmsResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户
 * @author lizj
 */
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService {
    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void insert(User userEntity) {
        userMapper.insert(userEntity);
    }

    @Override
    public void del(User userEntity) {
        userMapper.deleteByPrimaryKey(userEntity.getId());
    }

    @Override
    public User getUserEntityByLoginName(String loginName) {
        return userMapper.getUserEntityByLoginName(loginName);
    }

    @Override
    public User getUserByLoginName(String loginName) {
        return userMapper.getUserByLoginName(loginName);
    }



    @Override
    public WmsResult insertUser(User userEntity) {
        int i = userMapper.insertSelective(userEntity);
        if (i > 0) {
            return WmsResult.success("新增成功！");
        } else {
            return WmsResult.fail("新增失败！");
        }

    }

    @Override
    public WmsResult updateUser(User userEntity) {
        int i = userMapper.updateByPrimaryKeySelective(userEntity);
        if (i > 0) {
            return WmsResult.success("修改成功！");
        } else {
            return WmsResult.fail("修改失败！");
        }
    }

    @Override
    public void deleteUsers(List<Integer> groupId) {
        for (Integer userId : groupId) {
            userMapper.deleteByPrimaryKey(userId);
        }
    }

    @Override
    public PageUtils<User> getPage(String name, Integer pageSize, Integer currentPage) {
        Map map = new HashMap();
        map.put("name", name);

        //查询总数
        Integer totalCount = userMapper.selectCount(map);
        //创建分页对象,totalCount用于计算总页数
        PageUtils<User> pageBean = new PageUtils<User>(currentPage, totalCount, pageSize);
        //调用Dao查询分页列表数据
        Integer startRow = pageBean.getStart();
        Integer size = pageBean.getPageSize();
        map.put("startRow", startRow);
        map.put("size", size);

        //条件查询对象列表，将查找对象列表放入分页对象
        List<User> beans = userMapper.getList(map);
        pageBean.setBeans(beans);

        return pageBean;
    }

    @Override
    public WmsResult delUserById(Integer userId) {
        int i = userMapper.deleteByPrimaryKey(userId);
        if (i > 0) {
            return WmsResult.success("删除成功！");
        } else {
            return WmsResult.fail("删除失败！");
        }
    }

    @Override
    public List<String> getRolesById(Integer userId) {

        return roleMapper.getRolesByUserId(userId);
    }

    @Override
    public WmsResult updateRole(List<Integer> groupId, Integer userId) {
        List<UserRole> users = new ArrayList();
        for (Integer roleId : groupId) {
            UserRole ur = new UserRole(userId, roleId);
            users.add(ur);
        }
        try {
            userRoleMapper.delById(userId);
            userRoleMapper.insertRelations(users);
        } catch (RuntimeException e) {
            log.info("存储失败！");
            e.printStackTrace();
            return WmsResult.fail("存储失败！");
        }
        return WmsResult.success("操作成功！");
    }
}


