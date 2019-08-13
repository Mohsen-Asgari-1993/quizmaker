package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizController {

    @Autowired
    CourseResource courseResource;

    @GetMapping("/{id}")
    public String getQuizzes(@PathVariable Long id, Model model) {
        model.addAttribute("quizzes", courseResource.getById(id).getBody().getQuizzes());
        model.addAttribute("quiz", new QuizDTO());
        return "teacherQuiz";
    }
}
