package ir.maktab25.quizmaker.service.impl.base;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.repository.base.BaseQuestionRepository;
import ir.maktab25.quizmaker.service.QuizService;
import ir.maktab25.quizmaker.service.base.BaseQuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class BaseQuestionServiceImpl<E extends Question, PK extends Serializable, Repo extends BaseQuestionRepository<E, PK>>
        extends BaseServiceImpl<E, PK, Repo> implements BaseQuestionService<E, PK> {

    @Autowired
    QuizService quizService;

    @Autowired
    UserService userService;

    public BaseQuestionServiceImpl(Repo baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<E> findAllByTeacherUsername(String username){
        return baseRepository.findAllByTeacher_UserName(username);
    }

    @Override
    public E addQuestion(Long quizId, E e) {
        e.setTeacher(userService.findByUserName(CurrentUserDetail.getCurrentUsername()));
        E save = save(e);
        Quiz quiz = quizService.findOne(quizId);
        quiz.getQuestions().add(save);
        quizService.save(quiz);
        return save;
    }
}
