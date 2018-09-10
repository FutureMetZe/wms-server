package com.eshore.wms.dao;

import com.eshore.wms.pojo.RoleWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author eshore
 * @createDate 2018年9月6日
 */
public interface RoleMapper {
    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果状态码
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入一条数据
     *
     * @param record record
     * @return 结果状态码
     */
    int insert(RoleWithBLOBs record);

    /**
     * insertSelective
     *
     * @param record record
     * @return 结果状态码
     */
    int insertSelective(RoleWithBLOBs record);

    /**
     * 通过id获取
     *
     * @param id id
     * @return 结果状态码
     */
    RoleWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKeySelective(RoleWithBLOBs record);

    /**
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKeyWithBLOBs(RoleWithBLOBs record);
    /**
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKey(RoleWithBLOBs record);

    /**
     * 获取role列表
     * @param pageSize pageSize
     * @param start start
     * @return ArrayList<RoleWithBLOBs>
     */
    ArrayList<RoleWithBLOBs> rolesList(@Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * 获取role列表的总量
     * @param pageSize pageSize
     * @param start start
     * @return Integer
     */
    Integer rolesSize(@Param("pageSize") int pageSize, @Param("start") int start);


    /**
     * 通过id得到Modules集合
     * @param id id
     * @return List<String>
     */
    List<String> getModulesById(@Param("id") int id);

    /**
     * 得到角色全部数据
     * @return List<RoleWithBLOBs>
     */
    List<RoleWithBLOBs> allRoles();

    /**
     * 通过UserId得到对应的role
     * @param id id
     * @return List<String>
     */
    List<String> getRolesByUserId(int id);
    
    /**
     * 删除角色信息
     * @param groupId groupId
     */
    void deleteRoles(@Param("groupId") List<String> groupId);

}
