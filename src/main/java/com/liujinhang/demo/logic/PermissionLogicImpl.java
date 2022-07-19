package com.liujinhang.demo.logic;

import com.liujinhang.demo.entity.Permission;
import com.liujinhang.demo.repository.jpa.DepartmentRepository;
import com.liujinhang.demo.repository.jpa.PermissionRepository;
import com.liujinhang.demo.repository.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class PermissionLogicImpl implements PermissionLogic {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UserRepository userRepository;

    public Permission createPermission(Permission newPermission) throws Exception {

        // check department existed.
        var departmentExisted = departmentRepository.existsById(newPermission.getDepartment().getId());

        if(!departmentExisted) throw new Exception("department is not existed.");

        // check user existed.
        var userExisted = userRepository.existsById(newPermission.getUser().getId());

        if(!userExisted) throw new Exception("user is not existed.");

        // save permission.
        return permissionRepository.saveAndFlush(newPermission);

    }

    public Permission findPermissionById(int id) throws Exception {

        entityManager.clear();

        var permissionOptional = permissionRepository.findById(id);

        if(permissionOptional.isPresent()){
            return permissionOptional.get();
        }else{
            throw new Exception("permission is not existed.");
        }
    }

}
