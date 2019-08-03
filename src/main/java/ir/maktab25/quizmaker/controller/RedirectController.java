package ir.maktab25.quizmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @GetMapping("/admin.html")
    public String adminPage() {
        return "/admin.html";
    }

    @GetMapping("/teacher.html")
    public String teacherPage() {
        return "/teacher.html";

    }

    @GetMapping("/student.html")
    public String studentPage() {
        return "/student.html";

    }
}
