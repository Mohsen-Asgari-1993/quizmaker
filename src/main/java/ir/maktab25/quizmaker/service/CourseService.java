package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.domain.Course;

import java.util.List;
import java.util.Set;

public interface CourseService extends BaseService<Course, Long> {

    List<Course> findAllByTeacher(BaseUser teacher);

    List<Course> findAllByStudents(BaseUser students);

    Course addTeacher(BaseUser teacher);

    Course addStudent(BaseUser student);

    Course addStudents(Set<BaseUser> students);

}
