package com.zhao.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = -2435333675739532659L;

    private String userId;
    private String name;



}
