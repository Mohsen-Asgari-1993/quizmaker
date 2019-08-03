package ir.maktab25.quizmaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    private String redirect = "/redirect";
    private String adminLink = "/admin";
    private String teacherLink = "/teacher";
    private String studentLink = "/student";

    @GetMapping("/admin/admin.html")
    public String adminPage() {
        return redirect + adminLink + "/admin.html";
    }

    @GetMapping("/teacher/teacher.html")
    public String teacherPage() {
        return redirect + teacherLink + "/teacher.html";

    }

    @GetMapping("/student/student.html")
    public String studentPage() {
        return redirect + studentLink + "/student.html";

    }
}
