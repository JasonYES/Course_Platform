package com.fang.CD1.service;

import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;

import java.util.List;

/**
 * Created by Fang Yi on 16-12-25.
 */
public interface CourseShowService {

    List<UserCourseModel> getChosen (int number);

    List<CourseModel> getCourses (List<UserCourseModel> listIn);

    List<CourseModel> getAllCourses ();

    List<CourseModel> getFilterCourses(List<UserCourseModel> list1, List<CourseModel> list2);

}
