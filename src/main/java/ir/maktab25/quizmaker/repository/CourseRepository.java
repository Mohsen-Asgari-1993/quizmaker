package ir.maktab25.quizmaker.repository;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findAllByTeacher(BaseUser teacher);

    List<Course> findAllByStudents(BaseUser students);


}
