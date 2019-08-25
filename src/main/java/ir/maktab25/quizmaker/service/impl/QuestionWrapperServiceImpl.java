package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.repository.QuestionWrapperRepository;
import ir.maktab25.quizmaker.service.QuestionService;
import ir.maktab25.quizmaker.service.QuestionWrapperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionWrapperServiceImpl extends BaseServiceImpl<QuestionWrapper, Long, QuestionWrapperRepository>
        implements QuestionWrapperService {

    private final
    QuestionService questionService;

    @Autowired
    public QuestionWrapperServiceImpl(QuestionWrapperRepository baseRepository, QuestionService questionService) {
        super(baseRepository);
        this.questionService = questionService;
    }

    @Override
    public QuestionWrapper save(QuestionWrapper t) {
        questionService.save(t.getQuestion());
        return super.save(t);
    }
}
