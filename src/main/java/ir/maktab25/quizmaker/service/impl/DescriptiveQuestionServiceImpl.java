package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.DescriptiveQuestion;
import ir.maktab25.quizmaker.repository.DescriptiveQuestionRepository;
import ir.maktab25.quizmaker.service.DescriptiveQuestionService;
import ir.maktab25.quizmaker.service.impl.base.BaseQuestionServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DescriptiveQuestionServiceImpl extends
        BaseQuestionServiceImpl<DescriptiveQuestion, Long, DescriptiveQuestionRepository>
        implements DescriptiveQuestionService {

    public DescriptiveQuestionServiceImpl(DescriptiveQuestionRepository baseRepository) {
        super(baseRepository);
    }
}
