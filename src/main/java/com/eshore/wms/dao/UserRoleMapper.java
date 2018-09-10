package com.eshore.wms.dao;

import com.eshore.wms.pojo.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 
 * @author eshore
 * @createDate 2018年9月6日
 */
public interface UserRoleMapper {

    /**
     * 通过userId得到关系List
     *
     * @param userId userId
     * @return List<UserRole>
     */
    List<UserRole> getRelationByUserId(@Param("userId") int userId);

    /**
     * 通过userId删除关系
     *
     * @param userId userId
     */
    void delById(@Param("userId") int userId);

    /**
     * 批量插入关系数据
     * @param relationList relationList
     */
    void insertRelations(List<UserRole> relationList);
    /**
     * 
     * @param roleId 角色Id
     * @return List<String> 所有被使用的角色id
     */
     List<String> getAllRoleIdUsedByRoleId(@Param("roleId") String roleId);
}
