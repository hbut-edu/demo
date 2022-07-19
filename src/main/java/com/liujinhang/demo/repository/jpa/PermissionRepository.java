package com.liujinhang.demo.repository.jpa;

import com.liujinhang.demo.entity.Permission;
import com.liujinhang.demo.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
