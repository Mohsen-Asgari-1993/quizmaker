package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.domain.Quiz;

import java.util.List;

public interface QuizService extends BaseService<Quiz, Long> {

    List<Quiz> findAllByTeacherId(Long id);

    Long countByTeacherUsername();

    Long countByStudentUsername();

    Quiz addQuestion(Long quizId, List<Long> questionsId);

    Quiz changeState(Long quizId);

    Quiz deleteQuestion(Long quizId, Long questionId);

    List<Quiz> findAllByQuestionId(Long questionId);

}
