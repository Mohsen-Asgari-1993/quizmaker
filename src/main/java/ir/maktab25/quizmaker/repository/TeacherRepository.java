package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.base.BasicUserRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends BasicUserRepository<Teacher, Long> {

    List<Teacher> findAllByCode(String code);
}
