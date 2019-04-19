package com.fang.CD1.controller;

import com.fang.CD1.model.ChooseModel;
import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;
import com.fang.CD1.service.CourseChooseService;
import com.fang.CD1.service.CourseShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Fang Yi on 16-12-25.
 */
@Controller

public class CourseController {

    @Autowired
    CourseShowService courseShowService;
    @Autowired
    CourseChooseService courseChooseService;

    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String course(HttpSession httpSession, Model model) {

        int userName =(Integer) httpSession.getAttribute("userName");

//        List<UserCourseModel> list1 = courseShowService.getChosen(userName);
//        List<CourseModel> list = courseShowService.getCourses(list1);
        List<UserCourseModel> list1 = courseShowService.getChosen(userName);
        List<CourseModel> list = courseShowService.getCourses(list1);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());
        return "coursex";
    }

    @RequestMapping(value = "/Allcoursex", method = RequestMethod.GET)
    public String courses(Model model) {
        String courseNo = " ";

        List<UserCourseModel> list1 = courseShowService.getChosen(150410410);
        List<CourseModel> list2 = courseShowService.getAllCourses();
        List<CourseModel> list = courseShowService.getFilterCourses(list1, list2);

        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());

        return "Allcoursex";
    }

    @RequestMapping(value = "/Allcoursex", method = RequestMethod.POST)
    public String choose(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.chooseOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/Allcoursex";
    }

    @RequestMapping(value = "/Delete", method = RequestMethod.POST)
    public String delete(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.deleteOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/course";
    }
}