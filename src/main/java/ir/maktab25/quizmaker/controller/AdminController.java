package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.controller.util.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/courses")
    public String getCourses(){
        return Path.REDIRECT + Path.ADMIN + Path.COURSE + "course";
    }
}
