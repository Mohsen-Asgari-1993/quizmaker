package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.repository.base.BasicUserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends BasicUserRepository<Student, Long> {
}
