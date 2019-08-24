package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.domain.Quiz;

import java.util.List;

public interface QuizService extends BaseService<Quiz, Long> {

    List<Quiz> findAllByTeacherId(Long id);

    Long countByTeacherUsername();

    Quiz addQuestion(Long quizId, List<Long> questionsId);

}
