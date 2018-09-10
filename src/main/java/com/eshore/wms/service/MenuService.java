package com.eshore.wms.service;

import java.util.List;

import com.eshore.wms.pojo.Menu;

/**
 * 菜单管理service
 * @author eshore
 * @createDate 2018年9月5日
 */
public interface MenuService {

	/**
	 * 得到菜单List
	 * 
	 * @param id id
	 * @return List
	 */
	List<Menu> menuList(int id);

	/**
	 * 获取menus列表
	 * 
	 * @param pageSize pageSize
	 * @param start start
	 * @param menuId menuId
	 * @return List
	 */
	List<Menu> menusList(int pageSize, int start, String menuId);

	/**
	 * 获取menus列表的总量
	 * 
	 * @param start start
	 * @param pageSize pageSize
	 * @param menuId menuId
	 * @return Integer
	 */
	Integer menusSize(int pageSize, int start, String menuId);

	/**
	 * 新建菜单信息
	 * 
	 * @param menuEntity menuEntity
	 */
	void insertMenu(Menu menuEntity);

	/**
	 * 修改菜单信息
	 * 
	 * @param menuEntity menuEntity
	 */
	void updateMenu(Menu menuEntity);

	/**
	 * 删除菜单信息
	 * 
	 * @param groupId groupId
	 */
	void deleteMenus(List<String> groupId);

	/**
	 * 通过parentId得到menus列表
	 * 
	 * @param parentId parentId
	 * @return List
	 */
	List<Menu> menusByParentId(int parentId);

	/**
	 * 获取二级菜单
	 * @return List
	 */
	List<Menu> getSubmenus();

}
