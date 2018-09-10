package com.eshore.wms.pojo;

import java.io.Serializable;

/**
 * 完整权限表
 */
public class RoleWithBLOBs extends Role implements Serializable {
    private String modules;

    private String describe;

    public String getModules() {
        return modules;
    }

    public void setModules(String modules) {
        this.modules = modules == null ? null : modules.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }
}