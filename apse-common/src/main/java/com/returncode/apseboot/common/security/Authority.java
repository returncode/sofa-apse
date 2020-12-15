package com.returncode.apseboot.common.security;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority {

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限编码
     */
    private String authority;


    public Authority(String name, String authority) {
        this.name = name;
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
