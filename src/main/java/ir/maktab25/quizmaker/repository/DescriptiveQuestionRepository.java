package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.DescriptiveQuestion;
import ir.maktab25.quizmaker.repository.base.BaseQuestionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptiveQuestionRepository extends BaseQuestionRepository<DescriptiveQuestion, Long> {
}
