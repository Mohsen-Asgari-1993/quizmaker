package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.rest.QuestionResource;
import ir.maktab25.quizmaker.rest.QuizResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.DescriptiveQuestionDTO;
import ir.maktab25.quizmaker.service.dto.MultipleChoiceQuestionDTO;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher/question")
public class TeacherQuestionController {

    @Autowired
    QuizResource quizResource;

    @Autowired
    QuestionResource questionResource;

    @Autowired
    TeacherResource teacherResource;

    @GetMapping("/{quizId}")
    public String showQuestions(@PathVariable Long quizId, Model model) {
        bindDataForTeacherQuestions(quizId, model);
        return "teacherQuestions";
    }

    @GetMapping("/addQuestionPage/{quizId}")
    public String addQuestionPage(@PathVariable Long quizId, Model model) {
        bindDataForAddQuestionPage(quizId, model);
        return "addQuestion";
    }

    @PostMapping("/addFromBank/{quizId}")
    public String addFromBank(@PathVariable Long quizId, Model model, List<Long> longList) {


        bindDataForTeacherQuestions(quizId, model);
        return "teacherQuestions";
    }

    private void bindDataForAddQuestionPage(Long quizId, Model model) {
        model.addAttribute("MultipleChoiceQuestion", new MultipleChoiceQuestionDTO());
        model.addAttribute("DescriptiveQuestion", new DescriptiveQuestionDTO());
        model.addAttribute("quizId", quizId);
        model.addAttribute("questionBank", questionResource.findAllTeacherQuestions().getBody());
        model.addAttribute("idList", new ArrayList<Long>());
        model.addAttribute("name", teacherResource.findAllByUsername(CurrentUserDetail.getCurrentUsername()).getBody().getLastName());

    }

    private void bindDataForTeacherQuestions(Long quizId, Model model) {
        QuizDTO quizDTO = quizResource.getById(quizId).getBody();
        model.addAttribute("questions", quizDTO.getQuestions());
        model.addAttribute("quizName", quizDTO.getTitle());
        model.addAttribute("quizId", quizId);
        model.addAttribute("name", teacherResource.findAllByUsername(CurrentUserDetail.getCurrentUsername()).getBody().getLastName());

    }
}
