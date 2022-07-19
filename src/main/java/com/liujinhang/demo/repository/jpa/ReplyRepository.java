package com.liujinhang.demo.repository.jpa;

import com.liujinhang.demo.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

}
