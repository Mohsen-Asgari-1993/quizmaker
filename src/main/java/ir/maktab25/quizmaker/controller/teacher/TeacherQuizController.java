package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.QuizResource;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher/quiz")
public class TeacherQuizController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    QuizResource quizResource;

    @GetMapping("/{id}")
    public String getQuizzes(@PathVariable Long id, Model model) {
        bindDataForTeacherQuiz(id, model);
        return "teacherQuiz";
    }

    @PostMapping("/addQuiz/{id}")
    public String addQuiz(@PathVariable Long id, Model model, QuizDTO quizDTO) {
        quizDTO.setId(null);
        courseResource.addQuiz(quizDTO, id);
        bindDataForTeacherQuiz(id, model);
        return "teacherQuiz";
    }

    @GetMapping("/delete/{courseId}/{quizId}")
    public String deleteQuiz(@PathVariable Long courseId, @PathVariable Long quizId, Model model) {
        courseResource.deleteQuiz(courseId, quizId);
        bindDataForTeacherQuiz(courseId, model);
        return "teacherQuiz";
    }

    @GetMapping("/show/{id}")
    public String showQuiz(@PathVariable Long id, Model model) {
        bindDataForSingleQuizPage(id, model);
        return "teacherSingleQuiz";
    }

    @PostMapping("/updateQuiz/{courseId}/{quizId}")
    public String updateQuiz(@PathVariable("courseId") Long courseId,
                             @PathVariable("quizId") Long quizId,
                             Model model, QuizDTO quizDTO) {
        quizDTO.setId(quizId);
        quizResource.update(quizDTO);
        bindDataForTeacherQuiz(courseId, model);
        return "teacherQuiz";
    }


    private void bindDataForTeacherQuiz(Long id, Model model) {
        model.addAttribute("quizzes", courseResource.getById(id).getBody().getQuizzes());
        model.addAttribute("quizDTO", new QuizDTO());
        model.addAttribute("courseId", id);
    }

    private void bindDataForSingleQuizPage(Long id, Model model) {
        model.addAttribute("quiz", quizResource.getById(id).getBody());
        model.addAttribute("courseId", id);
    }
}
