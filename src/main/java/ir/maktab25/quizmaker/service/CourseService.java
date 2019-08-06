package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.domain.Course;

import java.util.List;
import java.util.Set;

public interface CourseService extends BaseService<Course, Long> {


    List<Course> findAllByTeacher(Long teacher_id);

    List<Course> findAllByStudents(User students);

    Course addTeacher(User teacher, Long id);

    Course addStudent(User student, Long id);

    Course addStudents(Set<User> students, Long id);

    Boolean existByCode(Integer code);

    Course findTop();
}
