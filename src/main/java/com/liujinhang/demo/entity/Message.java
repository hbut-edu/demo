package com.liujinhang.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @Getter @Setter private String message;

    @OneToOne
    @JoinColumn(name = "create_user_id")
    @Getter @Setter private User createUser;

    @CreatedDate
    @Getter @Setter private Date createDate;

}
