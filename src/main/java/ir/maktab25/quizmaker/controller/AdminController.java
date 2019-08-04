package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    TeacherResource teacherResource;

    @GetMapping("/course")
    public String getCourses(Model model) {
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        return "adminCourse";
    }

    @GetMapping("/teacher")
    public String getTeachers(Model model) {
        List<TeacherDTO> enables = teacherResource.findAllEnables().getBody();
        List<TeacherDTO> disables = teacherResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
        return "adminTeachers";
    }
}
