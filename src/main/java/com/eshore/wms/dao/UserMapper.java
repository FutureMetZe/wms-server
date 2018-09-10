package com.eshore.wms.dao;

import com.eshore.wms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * UserMapper
 */
public interface UserMapper {
    /**
     * @param id id
     * @return 结果状态码
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * @param record record
     * @return 结果状态码
     */
    int insert(User record);

    /**
     * @param record record
     * @return 结果状态码
     */
    int insertSelective(User record);

    /**
     * @param id id
     * @return 结果状态码
     */
    User selectByPrimaryKey(Integer id);

    /**
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKeySelective(User record);

    /**
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKey(User record);

    /**
     * 通过登录名拿到用户信息
     *
     * @param username username
     * @return 结果状态码
     */
    User getUserEntityByLoginName(@Param("username") String username);

    /**
     * 获取user对象
     *
     * @param username username
     * @return 结果状态码
     */
    User getUserByLoginName(@Param("username") String username);

    /**
     * 获取user列表的总量
     *
     * @param username username
     * @param pageSize 分页大小
     * @param start    起始页
     * @return 结果状态码
     */
    Integer usersSize(@Param("username") String username, @Param("pageSize") int pageSize, @Param("start") int start);

    /**
     * @param map map
     * @return 结果状态码
     */
    Integer selectCount(Map map);

    /**
     * @param map map
     * @return 结果状态码
     */
    List<User> getList(Map map);
}
