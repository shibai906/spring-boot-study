package com.zhao.springboot.entity.lifeTime;

import lombok.Data;

@Data
public class DayTime {
    private long id;
    private long day;               // 那一天
    private int feelHappyType;      // 满意度
    private int studyAmountType;    // 学习容量
    private String operator;        // 操作人
    private long createTime;        // 创建时间
}
