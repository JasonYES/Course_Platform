package com.fang.CD1.mapper;

import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Fang Yi on 18-2-26.
 */
public interface CSMapper {

    @Select("SELECT * FROM cs where Id = #{Id}")
//    @Results({
//            @Result(property = "Id",  column = "Id"),
//            @Result(property = "StuId", column = "StuId"),
//            @Result(property = "CourseId", column = "CourseId")
//    })
    List<UserCourseModel> getById(@Param("Id") int id);

}