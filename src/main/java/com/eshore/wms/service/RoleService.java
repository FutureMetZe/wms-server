package com.eshore.wms.service;

import java.util.List;

import com.eshore.wms.pojo.RoleWithBLOBs;

/**
 * 
 * @author eshore
 * @createDate 2018年9月6日
 */
public interface RoleService {

    /**
     * 获取role列表
     * 
     * @param pageSize pageSize
     * @param start start
     * @return List<RoleWithBLOBs>
     */
     List<RoleWithBLOBs> rolesList(int pageSize, int start);

    /**
     * 获取role列表的总量
     * 
    * @param pageSize pageSize
     * @param start start
     * @return List<RoleWithBLOBs>
     */
    Integer rolesSize(int pageSize, int start);

    /**
     * 新建角色信息
     * 
     * @param roleEntity roleEntity
     */
    void insertRole(RoleWithBLOBs roleEntity);

    /**
     * 更新角色信息
     * 
     * @param roleEntity roleEntity
     */
    void updateRole(RoleWithBLOBs roleEntity);

    /**
     * 删除角色信息
     * 
     * @param groupId groupId
     */
    void deleteRoles(List<String> groupId);

    /**
     * 得到角色全部数据
     * @return List<RoleWithBLOBs> 
     */
    List<RoleWithBLOBs> allRoles();
    
    /**
     * 
     * @param ids 要删除的角色id
     * @return List<String>
     */
    List<String> checkIds(List<String> ids);
}
