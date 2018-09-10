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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshore.wms.pojo.RoleWithBLOBs;
import com.eshore.wms.service.RoleService;
import com.eshore.wms.utils.PageResult;
import com.eshore.wms.utils.SimpleResponse;

import io.swagger.annotations.Api;
/**
 * 角色管理
 * @author eshore
 * @createDate 2018年9月6日
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色管理")
public class RoleController extends BaseController {
    private Logger log = LoggerFactory.getLogger(RoleController.class);

    @Resource(name = "roleServiceImpl")
    private RoleService roleService;

    /**
     * 获取role表数据
     * @param loginName loginName
     * @param pageSize pageSize
     * @param page page
     * @return PageResult
     */
    @GetMapping("/roles")
    public PageResult rolesList(String loginName, int pageSize, int page) {
        PageResult pageResult = new PageResult();
        pageResult.setData(roleService.rolesList(pageSize, page * pageSize));
        pageResult.setTotalCount(roleService.rolesSize(pageSize, page * pageSize));
        log.debug("The method is ending");
        return pageResult;
    }

    /**
     * 新建角色信息
     * 
     * @param roleEntity roleEntity
     * @return  RoleWithBLOBs
     */
    @PostMapping("/roles/role")
    public RoleWithBLOBs insertRole(@RequestBody RoleWithBLOBs roleEntity) {
        roleService.insertRole(roleEntity);
        log.debug("The method is ending");
        return roleEntity;
    }

    /**
     * 更新角色信息
     * 
     * @param roleEntity roleEntity
     * @param id id
     * @return RoleWithBLOBs RoleWithBLOBs
     */
    @PutMapping("/roles/{id}")
    public RoleWithBLOBs updateRole(@RequestBody RoleWithBLOBs roleEntity, @PathVariable int id) {
        if (roleEntity.getId() == id) {
            roleService.updateRole(roleEntity);
        }
        log.debug("The method is ending");
        return roleEntity;
    }

    /**
     * 删除角色信息
     * 
     * @param groupId groupId
     * @return List<String> ids
     */
    @DeleteMapping("/roles")
    public List<String> deleteRoles(@RequestBody List<String> groupId) {
        roleService.deleteRoles(groupId);
        return groupId;
    }
    /**
     * 检查对应角色是否可以被删除
     * @param ids 检查所有的id是否可以删除
     * @return SimpleResponse
     */
    @PostMapping("/check")
    public SimpleResponse checkIds(@RequestBody List<String> ids) {
        SimpleResponse response = new SimpleResponse(null);
        List<String> list = roleService.checkIds(ids);
        if (list == null || list.isEmpty()) {
            response.setStatus(SimpleResponse.SUCCESS);
        } else {
            response.setStatus(SimpleResponse.FAIL);
            response.setContent(list);
        }
        return response;
    }
    
    /**
     * 得到角色全部数据
     * @return List<RoleWithBLOBs>
     */
    @GetMapping("/roles/all")
    public List<RoleWithBLOBs> allRoles() {
        return roleService.allRoles();
    }

}
