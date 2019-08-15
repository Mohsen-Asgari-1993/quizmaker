package ir.maktab25.quizmaker.service.impl.base;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.repository.base.BaseQuestionRepository;
import ir.maktab25.quizmaker.service.base.BaseQuestionService;

import java.io.Serializable;
import java.util.List;

public class BaseQuestionServiceImpl<E extends Question, PK extends Serializable, Repo extends BaseQuestionRepository<E, PK>>
        extends BaseServiceImpl<E, PK, Repo> implements BaseQuestionService<E, PK> {

    public BaseQuestionServiceImpl(Repo baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<E> findAllByTeacherUsername(String username){
        return baseRepository.findAllByTeacher_UserName(username);
    }
}
