package com.fang.CD1.service;

import com.fang.CD1.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Fang Yi on 16-12-24.
 */
@Service
public class LoginService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean loginCheck(int number, int password){
        String sql = "select Password from student where StudentId ="+ number ;

        List<UserModel> list = jdbcTemplate.query(sql, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int i) throws SQLException {
                UserModel userModel = new UserModel();
                userModel.setPassword(rs.getString(1));
                return userModel;
            }
        });
        int passnum = Integer.parseInt(list.get(0).getPassword());
        if(password == passnum) return true;
        else return false;
    }
}
