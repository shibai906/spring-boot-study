package com.zhao.springboot.dao.lifeTime;

import com.zhao.springboot.entity.lifeTime.StudyTime;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudyTimeMapper{

    String tableName = "study_time" ;
    String columns = "id,type" ;

    @Select("select " + columns + " from " + tableName + " where id=#{id}")
    StudyTime get(@Param("id")long id);

}
