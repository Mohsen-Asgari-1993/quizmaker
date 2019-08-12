package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.repository.QuizRepository;
import ir.maktab25.quizmaker.service.QuizService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizServiceImpl extends BaseServiceImpl<Quiz, Long, QuizRepository> implements QuizService {

    public QuizServiceImpl(QuizRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Quiz> findAllByTeacherId(Long id) {
        return baseRepository.findAllByTeacher_Id(id);
    }
}
