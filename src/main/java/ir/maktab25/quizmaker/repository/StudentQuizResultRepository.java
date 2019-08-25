package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.StudentQuizResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentQuizResultRepository extends JpaRepository<StudentQuizResult, Long> {

    StudentQuizResult findByStudentIdAndQuiz_Id(Long studentId, Long quiz_id);
}
