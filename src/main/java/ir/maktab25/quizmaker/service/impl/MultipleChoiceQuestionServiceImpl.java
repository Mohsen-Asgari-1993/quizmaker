package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.Answer;
import ir.maktab25.quizmaker.domain.MultipleChoiceQuestion;
import ir.maktab25.quizmaker.repository.MultipleChoiceQuestionRepository;
import ir.maktab25.quizmaker.service.AnswerService;
import ir.maktab25.quizmaker.service.MultipleChoiceQuestionService;
import ir.maktab25.quizmaker.service.impl.base.BaseQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MultipleChoiceQuestionServiceImpl extends
        BaseQuestionServiceImpl<MultipleChoiceQuestion, Long, MultipleChoiceQuestionRepository>
        implements MultipleChoiceQuestionService {

    private final
    AnswerService answerService;

    @Autowired
    public MultipleChoiceQuestionServiceImpl(MultipleChoiceQuestionRepository baseRepository, AnswerService answerService) {
        super(baseRepository);
        this.answerService = answerService;
    }

    @Override
    public MultipleChoiceQuestion addQuestion(Long quizId, MultipleChoiceQuestion multipleChoiceQuestion) {
        List<Answer> answers = new ArrayList<>();
        multipleChoiceQuestion.getAnswers().forEach(
                a ->  answers.add(answerService.save(a))
        );
        multipleChoiceQuestion.setAnswers(answers);
        return super.addQuestion(quizId, multipleChoiceQuestion);
    }
}
