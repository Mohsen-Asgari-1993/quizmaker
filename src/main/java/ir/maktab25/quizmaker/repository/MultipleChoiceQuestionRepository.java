package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.MultipleChoiceQuestion;
import ir.maktab25.quizmaker.repository.base.BaseQuestionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MultipleChoiceQuestionRepository extends BaseQuestionRepository<MultipleChoiceQuestion, Long> {
}
