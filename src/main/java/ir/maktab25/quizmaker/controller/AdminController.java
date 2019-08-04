package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
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

    @GetMapping("/course")
    public String getCourses(Model model) {
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body );
        return "adminCourse";
    }
}
