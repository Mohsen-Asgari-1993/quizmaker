package ir.maktab25.quizmaker.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.QuizResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {

    @Autowired
    TeacherResource teacherResource;

    @Autowired
    StudentResource studentResource;

    @Autowired
    CourseResource courseResource;

    @Autowired
    QuizResource quizResource;

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("enableTeachers", teacherResource.countAllEnables().getBody());
        model.addAttribute("disableTeachers", teacherResource.countAllDisable().getBody());
        model.addAttribute("enableStudent", studentResource.countAllEnables().getBody());
        model.addAttribute("disableStudent", studentResource.countAllDisable().getBody());
        model.addAttribute("allCourse", courseResource.countAll().getBody());
        return "admin";
    }

    @GetMapping("/teacher")
    public String teacherPage(Model model) {
        model.addAttribute("course", courseResource.countByTeacherUserName(CurrentUserDetail.getCurrentUsername()).getBody());
        model.addAttribute("quiz", quizResource.countByTeacherUsername(CurrentUserDetail.getCurrentUsername()).getBody());
        return "teacher";
    }

    @GetMapping("/student")
    public String studentPage() {
        return "student";
    }
}
