package com.eshore.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshore.wms.dao.RoleMapper;
import com.eshore.wms.dao.UserRoleMapper;
import com.eshore.wms.pojo.RoleWithBLOBs;
import com.eshore.wms.service.RoleService;

/**
 * 
 * @author eshore
 * @createDate 2018年9月6日
 */
@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<RoleWithBLOBs> rolesList(int pageSize, int start) {
        return roleMapper.rolesList(pageSize, start);
    }

    @Override
    public Integer rolesSize(int pageSize, int start) {
        return roleMapper.rolesSize(pageSize, start);
    }

    @Override
    public void insertRole(RoleWithBLOBs roleWithBLOBs) {
        roleWithBLOBs.setRole("default");
        roleMapper.insertSelective(roleWithBLOBs);
    }

    @Override
    public void updateRole(RoleWithBLOBs roleWithBLOBs) {
        roleMapper.updateByPrimaryKeySelective(roleWithBLOBs);
    }

    @Override
    public void deleteRoles(List<String> groupId) {
        roleMapper.deleteRoles(groupId);
    }

    @Override
    public List<RoleWithBLOBs> allRoles() {
        return roleMapper.allRoles();
    }

    @Override
    public List<String> checkIds(List<String> ids) {
        List<String> list = null;
        if (ids != null && ids.size() > 0) {
            list = new ArrayList<>();
            for (String id : ids) {
                if (isActive(id)) {
                    list.add(id);
                }
            }
        }
        return list;
    }
    /**
     * 是否被使用
     * @param id id
     * @return boolean
     */
    private boolean isActive(String id) {
        List<String> ids = userRoleMapper.getAllRoleIdUsedByRoleId(id);
        if (ids == null || ids.size() == 0) {
            return false;
        }
        return true;
    }

}
