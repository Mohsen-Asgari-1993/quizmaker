package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.repository.QuestionRepository;
import ir.maktab25.quizmaker.service.QuestionService;
import ir.maktab25.quizmaker.service.impl.base.BaseQuestionServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionServiceImpl extends BaseQuestionServiceImpl<Question, Long, QuestionRepository>
        implements QuestionService {

    public QuestionServiceImpl(QuestionRepository baseRepository) {
        super(baseRepository);
    }

    //TODO override delete method for deleting question from bank
}
