package com.liujinhang.demo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.liujinhang.demo.entity.Thread;

import java.util.List;

@CrossOrigin
public interface ThreadRepository extends JpaRepository<Thread, Integer> {

}
