package com.fang.CD1.serviceimpl;

import com.fang.CD1.mapper.CSMapper;
import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;
import com.fang.CD1.service.CourseShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Fang Yi on 16-12-25.
 */
@Service
public class CourseShowServiceImpl implements CourseShowService{

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CSMapper csMapper;

    @Override
    public List<UserCourseModel> getChosen(int Stunumber) {

        List<UserCourseModel> list = csMapper.getById(Stunumber);
//        String sql ="select * from cs where StuId = " + Stunumber;
//        List list = jdbcTemplate.query(sql, new RowMapper() {
//            @Override
//            public Object mapRow(ResultSet rs, int i) throws SQLException {
//                UserCourseModel userCourseModel = new UserCourseModel();
//                userCourseModel.setCourseId(rs.getInt(3));
//                return userCourseModel;
//            }
//        });
        return list;
    }

    @Override
    public List<CourseModel> getCourses(List<UserCourseModel> listIn) {

        List<CourseModel> listOut = new ArrayList<CourseModel>();
        Iterator<UserCourseModel> iterator = listIn.iterator();
        while (iterator.hasNext()){
            String sql = "select * from course where Id =" + iterator.next().getCourseId();
            List list = jdbcTemplate.query(sql, new org.springframework.jdbc.core.RowMapper() {
                @Override
                public Object mapRow(ResultSet rs, int i) throws SQLException {
                    CourseModel courseModel = new CourseModel();
                    courseModel.setId(rs.getInt("Id"));
                    courseModel.setCourse(rs.getString("Course"));
                    courseModel.setTime(rs.getInt("Time"));
                    courseModel.setStartWeek(rs.getInt("StartWeek"));
                    courseModel.setEndWeek(rs.getInt("EndWeek"));
                    courseModel.setClassroom(rs.getString("ClassRoom"));
                    courseModel.setMajor(rs.getInt("Major"));
                    courseModel.setGrade(rs.getInt("Grade"));
                    courseModel.setTeacher(rs.getString("Teacher"));
                    return courseModel;
                }
            });
            listOut.addAll(list);
        }
        return listOut;
    }

    @Override
    public List<CourseModel> getAllCourses() {
        String sql = "select * from course";
        List list = jdbcTemplate.query(sql, new org.springframework.jdbc.core.RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                CourseModel courseModel = new CourseModel();
                courseModel.setId(rs.getInt("Id"));
                courseModel.setCourse(rs.getString("Course"));
                courseModel.setTime(rs.getInt("Time"));
                courseModel.setStartWeek(rs.getInt("StartWeek"));
                courseModel.setEndWeek(rs.getInt("EndWeek"));
                courseModel.setClassroom(rs.getString("ClassRoom"));
                courseModel.setTeacher(rs.getString("Teacher"));
                courseModel.setFloor(rs.getInt("Floor"));
                courseModel.setZhou(rs.getInt("Zhou"));
                courseModel.setFen(rs.getInt("Fen"));
                return courseModel;
            }
        });
        return list;
    }

    @Override
    public List<CourseModel> getFilterCourses(List<UserCourseModel> list1, List<CourseModel> list2) {
        Iterator<UserCourseModel> iterator = list1.iterator();
        while (iterator.hasNext()){
            UserCourseModel us = iterator.next();
            Iterator<CourseModel> iter = list2.iterator();
            while(iter.hasNext()){
                if(iter.next().getId() == us.getCourseId()) {
                    iter.remove();
                    break;
                }
            }
        }
        return list2;
    }
}
