package com.fengquanwei.webapp.chapter3;

import com.fengquanwei.framework.helper.DatabaseHelper;
import com.fengquanwei.plugin.security.SmartSecurity;

import java.util.Set;

/**
 * 应用安全控制
 *
 * @author fengquanwei
 * @create 2017/12/12 15:22
 **/
public class AppSecurity implements SmartSecurity {
    @Override
    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return DatabaseHelper.query(sql, username);
    }

    @Override
    public Set<String> getRoleNameSet(String username) {
        String sql = "SELECT r.role_name FROM user u, user_role ur, role r WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
        return DatabaseHelper.querySet(sql, username);
    }

    @Override
    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT p.permission_name FROM role r, role_permission rp, permission p WHERE r.id = rp.role_id AND p.id = rp.permission_id AND r.role_name = ?";
        return DatabaseHelper.querySet(sql, roleName);
    }
}
