package com.fang.CD1.service;

import com.fang.CD1.model.CourseModel;

import java.util.List;

/**
 * Created by Fang Yi on 17-1-3.
 */
public interface SmartService {

    List<CourseModel> feiFanDian (List<CourseModel> li);

    List<CourseModel> gaoXueFen (List<CourseModel> li);

    List<CourseModel> xueShiDuan (List<CourseModel> li);

    List<CourseModel> jiaoShiJin (List<CourseModel> li);

}
