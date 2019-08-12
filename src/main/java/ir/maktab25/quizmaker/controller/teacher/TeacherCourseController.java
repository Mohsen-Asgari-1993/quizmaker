package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.rest.CourseResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher/course")
public class TeacherCourseController {

    @Autowired
    CourseResource courseResource;

    @GetMapping
    public String getCourses(Model model) {
        model.addAttribute("courses", courseResource.findAllByTeacherUserName(CurrentUserDetail.getCurrentUsername()));
        return "teacherCourse";
    }
}
