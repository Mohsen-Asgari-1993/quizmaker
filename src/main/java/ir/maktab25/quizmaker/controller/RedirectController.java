package ir.maktab25.quizmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/teacher")
    public String teacherPage() {
        return "teacher";
    }

    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }
}
