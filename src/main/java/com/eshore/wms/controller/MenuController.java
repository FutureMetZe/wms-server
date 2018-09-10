package com.eshore.wms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eshore.wms.pojo.Menu;
import com.eshore.wms.pojo.User;
import com.eshore.wms.service.MenuService;
import com.eshore.wms.service.UserService;
import com.eshore.wms.utils.PageResult;

/**
 * 菜单管理controller
 * @author eshore
 * @createDate 2018年9月5日
 */
@RestController
public class MenuController {

	private Logger log = LoggerFactory.getLogger(MenuController.class);

	@Resource(name = "menuServiceImpl")
	private MenuService menuService;

	@Resource(name = "userServiceImpl")
	private UserService userService;

	/**
	 * 获取该用户的菜单权限
	 * 
	 * @param loginName 用户账号
	 * @return List
	 */
	@GetMapping("/menu/{loginName}")
	public List<Menu> menuList(@PathVariable String loginName) {
		User userEntity = userService.getUserByLoginName(loginName);
		List<Menu> menuList = menuService.menuList(userEntity.getId());
		return menuList;
	}

	/**
	 * 获取menus表数据
	 * 
	 * @param pageSize 每页大小
	 * @param page 当前页码
	 * @param menuId menuId
	 * @return PageResult
	 */
	@GetMapping("/menus")
	public PageResult menusList(int pageSize, int page, String menuId) {
		PageResult pageResult = new PageResult();
		pageResult.setData(menuService.menusList(pageSize, page * pageSize, menuId));
		pageResult.setTotalCount(menuService.menusSize(pageSize, page * pageSize, menuId));
		log.debug("The method is ending");
		return pageResult;
	}

	/**
	 * 通过parentId得到menus列表
	 * 
	 * @param parentId parentId
	 * @return List
	 */
	@GetMapping("/menus/parentId")
	public List<Menu> menusByParentId(int parentId) {
		return menuService.menusByParentId(parentId);
	}

	/**
	 * 新建菜单信息
	 * 
	 * @param menuEntity menuEntity
	 * @return Menu
	 */
	@PostMapping("/menus/menu")
	public Menu insertMenu(@RequestBody Menu menuEntity) {
		menuService.insertMenu(menuEntity);
		log.debug("The method is ending");
		return menuEntity;
	}

	/**
	 * 修改菜单信息
	 * 
	 * @param menuEntity menuEntity
	 * @param id id
	 * @return Menu
	 */
	@PutMapping("/menus/{id}")
	public Menu updateMenu(@RequestBody Menu menuEntity, @PathVariable int id) {
		if (menuEntity.getId() == id) {
			menuService.updateMenu(menuEntity);
		}
		log.debug("The method is ending");
		return menuEntity;
	}

	/**
	 * 删除菜单信息
	 * 
	 * @param groupId groupId
	 * @return List
	 */
	@DeleteMapping("/menus")
	public List<String> deleteMenus(@RequestBody List<String> groupId) {
		menuService.deleteMenus(groupId);
		return groupId;
	}

	/**
	 * 获取二级菜单
	 * @return List
	 */
	@GetMapping("/menus/submenus")
	public List<Menu> getSubmenus() {
		return menuService.getSubmenus();
	}
}
