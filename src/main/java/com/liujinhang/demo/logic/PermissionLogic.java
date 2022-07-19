package com.liujinhang.demo.logic;

import com.liujinhang.demo.entity.Permission;

public interface PermissionLogic {

    public Permission createPermission(Permission newPermission) throws Exception;

    public Permission findPermissionById(int id) throws Exception;

}
