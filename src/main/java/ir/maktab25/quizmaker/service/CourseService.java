package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.domain.Course;

import java.util.List;
import java.util.Set;

public interface CourseService extends BaseService<Course, Long> {


    List<Course> findAllByTeacher(Long teacher_id);

    List<Course> findAllByStudents(BaseUser students);

    Course addTeacher(BaseUser teacher, Long id);

    Course addStudent(BaseUser student, Long id);

    Course addStudents(Set<BaseUser> students, Long id);

}
