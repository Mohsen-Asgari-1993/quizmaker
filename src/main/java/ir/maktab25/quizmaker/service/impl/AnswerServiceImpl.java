package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.domain.Answer;
import ir.maktab25.quizmaker.repository.AnswerRepository;
import ir.maktab25.quizmaker.service.AnswerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnswerServiceImpl extends BaseServiceImpl<Answer, Long, AnswerRepository> implements AnswerService {

    public AnswerServiceImpl(AnswerRepository baseRepository) {
        super(baseRepository);
    }
}
