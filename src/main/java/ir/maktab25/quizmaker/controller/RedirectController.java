package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.controller.util.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @GetMapping("/admin/admin.html")
    public String adminPage() {
        return Path.REDIRECT + Path.ADMIN + "/admin.html";
    }

    @GetMapping("/teacher/teacher.html")
    public String teacherPage() {
        return Path.REDIRECT + Path.TEACHER + "/teacher.html";

    }

    @GetMapping("/student/student.html")
    public String studentPage() {
        return Path.REDIRECT + Path.STUDENT + "/student.html";

    }
}
