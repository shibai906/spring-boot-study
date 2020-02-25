package com.zhao.springboot.service;

import com.zhao.springboot.dao.lifeTime.StudyTimeMapper;
import com.zhao.springboot.entity.lifeTime.StudyTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LifeTypeBiz {

    @Autowired
    StudyTimeMapper studyTimeMapper;

    public StudyTime get(long id) {
        return studyTimeMapper.get(id);
    }

}
