package com.returncode.common.security;

import java.io.Serializable;

public class AuthRole implements Serializable {

    private String roleId;
    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String roleCode;

    public AuthRole() {
    }

    public AuthRole(String roleId, String name, String roleCode) {
        this.roleId = roleId;
        this.name = name;
        this.roleCode = roleCode;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}
