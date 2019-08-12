package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByTeacher_Id(Long teacher_id);

    List<Course> findAllByTeacher_UserName(String username);

    List<Course> findAllByStudents(User students);

    Boolean existsByCode(Integer code);

    Long countAllByTeacher_UserName(String username);

}
