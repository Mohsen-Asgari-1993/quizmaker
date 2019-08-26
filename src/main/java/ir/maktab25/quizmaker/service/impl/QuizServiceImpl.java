package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.repository.QuizRepository;
import ir.maktab25.quizmaker.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class QuizServiceImpl extends BaseServiceImpl<Quiz, Long, QuizRepository> implements QuizService {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private QuestionWrapperService questionWrapperService;

    @Autowired
    TeacherService teacherService;

    @Autowired
    public QuizServiceImpl(QuizRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Quiz save(Quiz t) {
        t.setTeacher(teacherService.findByUserName(CurrentUserDetail.getCurrentUsername()));
        return super.save(t);
    }

    @Override
    public List<Quiz> findAllByTeacherId(Long id) {
        return baseRepository.findAllByTeacher_Id(id);
    }

    @Override
    public Long countByTeacherUsername() {
        return baseRepository.countAllByTeacher_UserName(CurrentUserDetail.getCurrentUsername());
    }

    @Override
    public Long countByStudentUsername() {
        List<Quiz> quizzes = baseRepository.findAllByStudents_UserName(CurrentUserDetail.getCurrentUsername());
        return (long) quizzes.size();
    }

    @Override
    public Quiz addQuestion(Long quizId, List<Long> questionsId) {
        Quiz quiz = findOne(quizId);
        questionsId.forEach(id -> {
            if (!isExisted(id, quiz.getQuestions()))
                quiz
                        .getQuestions()
                        .add
                                (questionWrapperService
                                        .save(
                                                new QuestionWrapper(null,
                                                        questionService.findOne(id),
                                                        null)));
        });
        return save(quiz);
    }

    @Override
    public Quiz changeState(Long quizId) {
        Quiz quiz = findOne(quizId);
        quiz.setActive(!quiz.isActive());
        return save(quiz);
    }

    @Override
    public Quiz deleteQuestion(Long quizId, Long questionId) {
        Quiz quiz = findOne(quizId);
        quiz.getQuestions().removeIf(wrapper -> wrapper.getId().equals(questionId));
        questionWrapperService.delete(questionId);
        return save(quiz);
    }

    @Override
    public List<Quiz> findAllByQuestionId(Long questionId) {
        return baseRepository.findAllByQuestions_Question_Id(questionId);
    }

    private boolean isExisted(Long id, Set<QuestionWrapper> questionWrappers) {
        for (QuestionWrapper ques : questionWrappers) {
            if (ques.getQuestion().getId().equals(id))
                return true;
        }
        return false;
    }
}
