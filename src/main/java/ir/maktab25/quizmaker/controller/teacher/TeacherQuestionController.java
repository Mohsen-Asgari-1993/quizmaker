package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.rest.*;
import ir.maktab25.quizmaker.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/teacher/question")
public class TeacherQuestionController {

    @Autowired
    QuizResource quizResource;

    @Autowired
    QuestionResource questionResource;

    @Autowired
    DescriptiveQuestionResource descriptiveQuestionResource;

    @Autowired
    MultipleChoiceQuestionResource multipleChoiceQuestionResource;

    @Autowired
    TeacherResource teacherResource;

    private static List<AnswerDTO> dtoList = new ArrayList<>();

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
        quizResource.addQuestion(quizId, longList);
        bindDataForTeacherQuestions(quizId, model);
        return "teacherQuestions";
    }

    @PostMapping("/addDescriptive/{quizId}")
    public String addDescriptive(@PathVariable Long quizId, Model model, DescriptiveQuestionDTO questionDTO) {
        descriptiveQuestionResource.addQuestion(quizId, questionDTO);

        bindDataForTeacherQuestions(quizId, model);
        return "teacherQuestions";
    }

    @PostMapping("/addMulti/{quizId}")
    public String addMulti(@PathVariable Long quizId, Model model, MultipleChoiceQuestionDTO multipleChoiceQuestionDTO) {
        multipleChoiceQuestionDTO.setAnswers(dtoList);
        multipleChoiceQuestionResource.addQuestion(quizId, multipleChoiceQuestionDTO);
        dtoList.removeIf(Objects::nonNull);
        bindDataForTeacherQuestions(quizId, model);
        return "teacherQuestions";
    }

    @PostMapping("/addAnswer/{quizId}")
    public String addAnswer(@PathVariable Long quizId, AnswerDTO answerDTO, Model model) {
        if (answerDTO.getBool().equals("false"))
            answerDTO.setIsTrue(false);
        else
            answerDTO.setIsTrue(true);
        dtoList.add(answerDTO);
        bindDataForAddQuestionPage(quizId, model);
        return "addQuestion";
    }

    @GetMapping("/deleteAnswer/{quizId}/{content}")
    public String deleteAnswer(@PathVariable Long quizId, @PathVariable String content, Model model) {
        dtoList.removeIf(a -> a.getContent().equals(content));
        bindDataForAddQuestionPage(quizId, model);
        return "addQuestion";
    }

    private void bindDataForAddQuestionPage(Long quizId, Model model) {
        model.addAttribute("MultipleChoiceQuestion", new MultipleChoiceQuestionDTO());
        model.addAttribute("DescriptiveQuestion", new DescriptiveQuestionDTO());
        model.addAttribute("quizId", quizId);
        model.addAttribute("questionBank", questionResource.findAllTeacherQuestions().getBody());
        model.addAttribute("idList", new ArrayList<Long>());
        model.addAttribute("name", teacherResource.findAllByUsername(CurrentUserDetail.getCurrentUsername()).getBody().getLastName());
        model.addAttribute("answerList", dtoList);
        model.addAttribute("newAnswer", new AnswerDTO());

    }

    private void bindDataForTeacherQuestions(Long quizId, Model model) {
        QuizDTO quizDTO = quizResource.getById(quizId).getBody();
        model.addAttribute("questions", quizDTO.getQuestions());
        model.addAttribute("quizName", quizDTO.getTitle());
        model.addAttribute("quizId", quizId);
        model.addAttribute("name", teacherResource.findAllByUsername(CurrentUserDetail.getCurrentUsername()).getBody().getLastName());

    }
}
