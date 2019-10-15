package com.zhao.springboot.entity.lifeTime;

import lombok.Data;

@Data
public class TypeTime {

    private long id;
    private long dayId;         // 今天表Id
    private long remark;        // 备注，可有可无
    private String what;        // 做了什么
    private long dayStart;      // 开始时间
    private long dayEnd;        // 结束时间
    private int type;           // 娱乐类型
    private String gain;        // 收获
    private long createTime;    // 创建时间

}
