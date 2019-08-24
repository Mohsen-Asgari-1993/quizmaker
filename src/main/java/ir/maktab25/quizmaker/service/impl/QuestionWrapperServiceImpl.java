package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.repository.QuestionWrapperRepository;
import ir.maktab25.quizmaker.service.QuestionWrapperService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionWrapperServiceImpl extends BaseServiceImpl<QuestionWrapper, Long, QuestionWrapperRepository>
        implements QuestionWrapperService {

    public QuestionWrapperServiceImpl(QuestionWrapperRepository baseRepository) {
        super(baseRepository);
    }
}
