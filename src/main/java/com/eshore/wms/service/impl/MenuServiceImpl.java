package com.eshore.wms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshore.wms.dao.MenuMapper;
import com.eshore.wms.dao.RoleMapper;
import com.eshore.wms.pojo.Menu;
import com.eshore.wms.service.MenuService;

/**
 * 菜单管理serviceimpl
 * @author eshore
 * @createDate 2018年9月5日
 */
@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuDao;
	
	@Autowired
	private RoleMapper roleDao;

	@Override
	public List<Menu> menuList(int id) {
		List<String> idList = roleDao.getModulesById(id);
		
		String idstemp = "";
		for (String idtemp : idList) {
			idstemp = idstemp + idtemp;
		}
		String[] ids = idstemp.split(";");
		List<Menu> parentMenuList = menuDao.getParentMenuListById(ids);
		List<Menu> childrenMenuList = menuDao.getMenuListById(ids);
		List<Menu> menuList = new ArrayList<Menu>();

		for (Menu parentMenu : parentMenuList) {
			List<Menu> menuListTemp = new ArrayList<Menu>();
			for (Menu childrenMenu : childrenMenuList) {
				if (parentMenu.getId() == childrenMenu.getParentId()) {
					menuListTemp.add(childrenMenu);
				}
			}
			parentMenu.setChildren(menuListTemp);
			menuList.add(parentMenu);
		}

		return menuList;
	}

	@Override
	public List<Menu> menusList(int pageSize, int start, String menuId) {
		return menuDao.menusList(pageSize, start, menuId);
	}

	@Override
	public Integer menusSize(int pageSize, int start, String menuId) {
		return menuDao.menusSize(pageSize, start, menuId);
	}

	@Override
	public void insertMenu(Menu menuEntity) {
		menuDao.insertMenu(menuEntity);
	}

	@Override
	public void updateMenu(Menu menuEntity) {
		menuDao.updateMenu(menuEntity);
	}

	@Override
	public void deleteMenus(List<String> groupId) {
		menuDao.deleteMenus(groupId);
	}

	@Override
	public List<Menu> menusByParentId(int parentId) {
		return menuDao.menusByParentId(parentId);
	}

	@Override
	public List<Menu> getSubmenus() {
		return menuDao.getSubmenus();
	}
}
