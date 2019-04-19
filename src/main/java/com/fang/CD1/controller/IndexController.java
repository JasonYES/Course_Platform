package com.fang.CD1.controller;

import com.fang.CD1.model.ChooseModel;
import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;
import com.fang.CD1.model.LoginModel;
import com.fang.CD1.service.LoginService;
import com.fang.CD1.service.CourseShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Fang Yi on 16-12-23.
 */
@Controller
public class IndexController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private CourseShowService courseShowService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexform(Model model) {
        model.addAttribute("loginModel", new LoginModel());

        return "indexx";
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    public String index(HttpSession httpSession, @ModelAttribute LoginModel loginModel, Model model) {
        int number = Integer.parseInt(loginModel.getUserName());
        int number2 = Integer.parseInt(loginModel.getPassWord());

        if(loginService.loginCheck(number, number2)) {

        httpSession.setAttribute("userName", loginModel.getUserName());

        List<UserCourseModel> list1 = courseShowService.getChosen(number);
        List<CourseModel> list = courseShowService.getCourses(list1);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());
            return "coursex";
        }
        else  return "redirect:/";
    }
}
