package com.eshore.wms.dao;

import com.eshore.wms.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * MenuMapper
 */
public interface MenuMapper {
    /**
     * 根据id删除
     *
     * @param id id
     * @return 结果状态码
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加
     *
     * @param record record
     * @return 结果状态码
     */
    int insert(Menu record);

    /**
     * insertSelective
     *
     * @param record record
     * @return 结果状态码
     */
    int insertSelective(Menu record);

    /**
     * @param id id
     * @return 结果状态码
     */
    Menu selectByPrimaryKey(Integer id);

    /**
     * updateByPrimaryKeySelective
     *
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * updateByPrimaryKeyWithBLOBs
     *
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKeyWithBLOBs(Menu record);

    /**
     * 更新
     *
     * @param record record
     * @return 结果状态码
     */
    int updateByPrimaryKey(Menu record);

    /**
     * 通过用户Id得到一级菜单List
     *
     * @param ids ids
     * @return 结果状态码
     */
    List<Menu> getParentMenuListById(@Param("ids") String[] ids);

    /**
     * 通过ids获取菜单列表
     *
     * @param ids ids
     * @return 结果状态码
     */
    List<Menu> getMenuListById(@Param("ids") String[] ids);

    /**
     * 获取menus列表
     *
     * @param pageSize 分页大小
     * @param start    起始页
     * @param menuId   菜单id
     * @return 结果状态码
     */
    List<Menu> menusList(@Param("pageSize") int pageSize, @Param("start") int start,
                         @Param("menuId") String menuId);

    /**
     * 获取menus列表的总量
     *
     * @param pageSize 分页大小
     * @param start    起始页
     * @param menuId   菜单id
     * @return 结果状态码
     */
    Integer menusSize(@Param("pageSize") int pageSize, @Param("start") int start,
                      @Param("menuId") String menuId);

    /**
     * 新建菜单信息
     *
     * @param menuEntity menuEntity
     */
    void insertMenu(@Param("menuEntity") Menu menuEntity);

    /**
     * 修改菜单信息
     *
     * @param menuEntity menuEntity
     */
    void updateMenu(@Param("menuEntity") Menu menuEntity);

    /**
     * 删除菜单信息
     *
     * @param groupId groupId
     */
    void deleteMenus(@Param("groupId") List<String> groupId);

    /**
     * 通过parentId得到menus列表
     *
     * @param parentId 父级菜单id
     * @return 结果状态码
     */
    List<Menu> menusByParentId(@Param("parentId") int parentId);

    /**
     * 获取二级菜单
     *
     * @return 结果状态码
     */
    List<Menu> getSubmenus();

}
