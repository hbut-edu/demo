package com.liujinhang.demo.restfulservice;

import com.liujinhang.demo.entity.Permission;
import com.liujinhang.demo.logic.PermissionLogic;
import com.liujinhang.demo.logic.PermissionLogicImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class PermissionController {

    @Autowired
    private PermissionLogic permissionLogic;

    @PostMapping(path = "permission",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Permission> create(@RequestBody Permission newPermission) throws Exception {

        permissionLogic.createPermission(newPermission);

        var permission = permissionLogic.findPermissionById(newPermission.getId());

        return new ResponseEntity<>(permission, HttpStatus.CREATED);
    }

}
