package ir.maktab25.quizmaker.service.base;

import ir.maktab25.quizmaker.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface BaseQuestionService<E, PK extends Serializable> extends BaseService<E, PK> {
    List<E> findAllByTeacherUsername(String username);

    E addQuestion(Long quizId, E e);
}
