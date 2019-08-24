package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
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

    @Autowired
    TeacherResource teacherResource;

    @GetMapping
    public String getCourses(Model model) {
        model.addAttribute("courses", courseResource.findAllByTeacherUserName().getBody());
        model.addAttribute("name", teacherResource.findAllByUsername().getBody().getLastName());

        return "teacherCourse";
    }
}
