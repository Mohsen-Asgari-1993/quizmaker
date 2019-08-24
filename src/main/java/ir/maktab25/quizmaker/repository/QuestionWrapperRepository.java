package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.QuestionWrapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionWrapperRepository extends JpaRepository<QuestionWrapper, Long> {
}
