package com.returncode.apseboot.common.utils;

import com.returncode.apseboot.common.security.AuthRole;
import com.returncode.apseboot.common.security.AuthUser;
import com.returncode.apseboot.common.security.Authority;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Collection;
import java.util.List;

/**
 * 用户鉴权工具类
 */
public class AuthUtil {

    /**
     * 获取当前用户鉴权
     *
     * @return
     */
    public static Authentication getAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    public static AuthUser getUser() {
        Object authUser = getAuth().getPrincipal();
        if (authUser instanceof AuthUser) {
            AuthUser user = (AuthUser) authUser;
            return user;
        }
        return null;
    }

    /**
     * 获取当前用户Unid
     *
     * @return
     */
    public static Long getUserUnid() {
        return getUser().getUnid();
    }

    /**
     * 获取当前用户名称
     *
     * @return
     */
    public static String getUserName() {
        return getUser().getUname();
    }

    /**
     * 获取当前用户角色
     *
     * @return
     */
    public static Collection<AuthRole> getRoles() {
        return getUser().getRoles();
    }

    /**
     * 获取当前用户权限
     *
     * @return
     */
    public static List<Authority> getAuthoritys() {
        List<Authority> authorities = (List<Authority>) getAuth().getAuthorities();
        return authorities;
    }

}
