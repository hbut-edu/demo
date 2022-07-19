package com.liujinhang.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "thread")
public class Thread extends Message{

    @OneToMany(mappedBy = "thread")
    @Getter @Setter private Set<Reply> replays;

}
