package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.MultipleChoiceQuestion;
import ir.maktab25.quizmaker.repository.MultipleChoiceQuestionRepository;
import ir.maktab25.quizmaker.service.MultipleChoiceQuestionService;
import ir.maktab25.quizmaker.service.impl.base.BaseQuestionServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MultipleChoiceQuestionServiceImpl extends
        BaseQuestionServiceImpl<MultipleChoiceQuestion, Long, MultipleChoiceQuestionRepository>
        implements MultipleChoiceQuestionService {

    public MultipleChoiceQuestionServiceImpl(MultipleChoiceQuestionRepository baseRepository) {
        super(baseRepository);
    }
}
