package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.base.BasicUserRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface TeacherRepository extends BasicUserRepository<Teacher, Long> {

    List<Teacher> findAllByCode(String code);
}
