package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findAllByTeacher_Id(Long id);

    Long countAllByTeacher_UserName(String username);
}
