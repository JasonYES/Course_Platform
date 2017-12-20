package com.fang.CD1.serviceimpl;

import com.fang.CD1.service.CourseChooseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Fang Yi on 17-1-2.
 */
@Service
public class CourseChooseServiceImpl implements CourseChooseService{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean deleteOne(int id, int number) {
        String sql = "delete from cs where courseId = " + number;
        jdbcTemplate.update(sql);
        return true;
    }

    @Override
    public boolean chooseOne(int id, int number) {
        String sql = "insert into cs (StuId, CourseId) values (150410410," + number+")";
        jdbcTemplate.update(sql);

        return true;
    }
}
