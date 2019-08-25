package ir.maktab25.quizmaker.controller.student;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    StudentResource studentResource;

    @GetMapping
    public String getCourse(Model model) {
        model.addAttribute("name", studentResource.findAllByUsername().getBody().getLastName());
        model.addAttribute("courses", courseResource.findAllByStudentUserName().getBody());
        return "studentCourse";
    }
}
