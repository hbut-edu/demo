package com.liujinhang.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reply extends Message{

    @ManyToOne
    @JoinColumn(name = "thread_id")
    @Getter @Setter private Thread thread;

}
