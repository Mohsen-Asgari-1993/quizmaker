package ir.maktab25.quizmaker.controller.teacher;

import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.rest.*;
import ir.maktab25.quizmaker.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/teacher/question")
public class TeacherQuestionController {

    private final
    QuizResource quizResource;

    private final
    QuestionResource questionResource;

    private final
    DescriptiveQuestionResource descriptiveQuestionResource;

    private final
    MultipleChoiceQuestionResource multipleChoiceQuestionResource;

    private final
    TeacherResource teacherResource;

    private final
    QuestionWrapperResource questionWrapperResource;


    private static List<AnswerDTO> dtoList = new ArrayList<>();

    @Autowired
    public TeacherQuestionController(QuizResource quizResource,
                                     QuestionResource questionResource,
                                     DescriptiveQuestionResource descriptiveQuestionResource,
                                     MultipleChoiceQuestionResource multipleChoiceQuestionResource,
                                     TeacherResource teacherResource,
                                     QuestionWrapperResource questionWrapperResource) {
        this.quizResource = quizResource;
        this.questionResource = questionResource;
        this.descriptiveQuestionResource = descriptiveQuestionResource;
        this.multipleChoiceQuestionResource = multipleChoiceQuestionResource;
        this.teacherResource = teacherResource;
        this.questionWrapperResource = questionWrapperResource;
    }

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

    @GetMapping("/show/{quizId}/{questionId}")
    public String showSingleQuestion(@PathVariable Long quizId, @PathVariable Long questionId, Model model) {
        bindDataForSingleQuestion(quizId, questionId, model);
        return "teacherSingleQuestion";

    }

    @PostMapping("/updateQuestion/{quizId}/{questionId}")
    public String updateQuestion(@PathVariable Long quizId, @PathVariable Long questionId, Model model, QuestionWrapperDTO questionWrapperDTO) {
        questionWrapperDTO.setId(questionId);
        questionWrapperResource.update(questionWrapperDTO);
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

    private void bindDataForSingleQuestion(Long quizId, Long questionId, Model model) {
        model.addAttribute("quizId", quizId);
        model.addAttribute("questionWrapper", questionWrapperResource.getById(questionId).getBody());
    }
}
