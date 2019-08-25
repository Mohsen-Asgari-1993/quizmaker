package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.repository.QuizRepository;
import ir.maktab25.quizmaker.service.QuestionService;
import ir.maktab25.quizmaker.service.QuestionWrapperService;
import ir.maktab25.quizmaker.service.QuizService;
import ir.maktab25.quizmaker.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuizServiceImpl extends BaseServiceImpl<Quiz, Long, QuizRepository> implements QuizService {

    private final
    QuestionService questionService;

    private final
    StudentService studentService;

    private final
    QuestionWrapperService questionWrapperService;

    @Autowired
    public QuizServiceImpl(QuizRepository baseRepository,
                           QuestionService questionService,
                           StudentService studentService,
                           QuestionWrapperService questionWrapperService) {

        super(baseRepository);
        this.questionService = questionService;
        this.studentService = studentService;
        this.questionWrapperService = questionWrapperService;
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
        return baseRepository.countAllByStudents_UserName(studentService.findByUserName());
    }

    @Override
    public Quiz addQuestion(Long quizId, List<Long> questionsId) {
        Quiz quiz = findOne(quizId);
        questionsId.forEach(id -> quiz
                .getQuestions()
                .add
                        (questionWrapperService
                                .save(
                                        new QuestionWrapper(null,
                                                questionService.findOne(id),
                                                null))));
        return super.save(quiz);
    }
}
