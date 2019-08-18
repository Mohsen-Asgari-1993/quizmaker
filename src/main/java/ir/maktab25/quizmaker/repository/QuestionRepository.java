package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.repository.base.BaseQuestionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends BaseQuestionRepository<Question, Long> {
}
