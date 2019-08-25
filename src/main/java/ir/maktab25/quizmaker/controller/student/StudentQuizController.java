package ir.maktab25.quizmaker.controller.student;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/student/quiz")
public class StudentQuizController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    StudentResource studentResource;

    @GetMapping("/{id}")
    public String getActiveQuiz(@PathVariable Long id, Model model) {
        bindDateForStudentQuiz(id, model);
        return "studentQuiz";
    }

    private void bindDateForStudentQuiz(Long courseId, Model model) {
        CourseDTO courseDTO = courseResource.getById(courseId).getBody();
        model.addAttribute("name", studentResource.findAllByUsername().getBody().getLastName());
        model.addAttribute("quizzes", courseDTO.getQuizzes().stream().filter(QuizDTO::isActive).collect(Collectors.toList()));
        model.addAttribute("courseName", courseDTO.getTitle());
    }
}
