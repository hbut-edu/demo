package com.liujinhang.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.liujinhang.demo.enumtype.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @OneToOne
    @JoinColumn(name = "department_id")
    @Getter @Setter private Department department;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    @Getter @Setter private User user;

    // 0: access denied 1: access as guest, 2: access as member, 3: access as manager
    @Enumerated(EnumType.ORDINAL)
    @Getter @Setter private AccessLevel accessLevel;
}
