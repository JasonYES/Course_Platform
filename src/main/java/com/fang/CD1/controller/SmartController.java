package com.fang.CD1.controller;

import com.fang.CD1.model.ChooseModel;
import com.fang.CD1.model.CourseModel;
import com.fang.CD1.model.UserCourseModel;
import com.fang.CD1.service.CourseChooseService;
import com.fang.CD1.service.CourseShowService;
import com.fang.CD1.service.SmartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Fang Yi on 17-1-3.
 */
@Controller
public class SmartController {

    @Autowired
    SmartService smartService;
    @Autowired
    CourseShowService courseShowService;
    @Autowired
    CourseChooseService courseChooseService;

    @RequestMapping(value = "/Smart", method = RequestMethod.GET)
    public String smart(Model model){

        return "Smart";
    }

    @RequestMapping(value = "/Smart1", method = RequestMethod.GET)
    public String smart1(Model model){
        List<UserCourseModel> list1 = courseShowService.getChosen(150410410);
        List<CourseModel> list2 = courseShowService.getAllCourses();
        List<CourseModel> list3 = courseShowService.getFilterCourses(list1, list2);

        List<CourseModel> list = smartService.feiFanDian(list3);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());

        return "Smart1";
    }

    @RequestMapping(value = "/Smart1", method = RequestMethod.POST)
    public String smart11(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.chooseOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/Smart1";
    }

    @RequestMapping(value = "/Smart2", method = RequestMethod.GET)
    public String smart2(Model model){
        List<UserCourseModel> list1 = courseShowService.getChosen(150410410);
        List<CourseModel> list2 = courseShowService.getAllCourses();
        List<CourseModel> list3 = courseShowService.getFilterCourses(list1, list2);

        List<CourseModel> list = smartService.gaoXueFen(list3);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());

        return "Smart2";
    }

    @RequestMapping(value = "/Smart2", method = RequestMethod.POST)
    public String smart22(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.chooseOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/Smart2";
    }

    @RequestMapping(value = "/Smart3", method = RequestMethod.GET)
    public String smart3(Model model){
        List<UserCourseModel> list1 = courseShowService.getChosen(150410410);
        List<CourseModel> list2 = courseShowService.getAllCourses();
        List<CourseModel> list3 = courseShowService.getFilterCourses(list1, list2);

        List<CourseModel> list = smartService.xueShiDuan(list3);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());

        return "Smart3";
    }

    @RequestMapping(value = "/Smart3", method = RequestMethod.POST)
    public String smart33(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.chooseOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/Smart3";
    }

    @RequestMapping(value = "/Smart4", method = RequestMethod.GET)
    public String smart4(Model model){
        List<UserCourseModel> list1 = courseShowService.getChosen(150410410);
        List<CourseModel> list2 = courseShowService.getAllCourses();
        List<CourseModel> list3 = courseShowService.getFilterCourses(list1, list2);

        List<CourseModel> list = smartService.jiaoShiJin(list3);
        model.addAttribute("list", list);
        model.addAttribute("chooseModel", new ChooseModel());

        return "Smart4";
    }

    @RequestMapping(value = "/Smart4", method = RequestMethod.POST)
    public String smart44(Model model, @ModelAttribute ChooseModel chooseModel) {
        int number = Integer.parseInt(chooseModel.getNo());
        courseChooseService.chooseOne(150410410, number);
        model.addAttribute("chooseModel", new ChooseModel());

        return "redirect:/Smart4";
    }
}
