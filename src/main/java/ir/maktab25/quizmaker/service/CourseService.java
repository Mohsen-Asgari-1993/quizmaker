package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Quiz;

import java.util.List;

public interface CourseService extends BaseService<Course, Long> {


    List<Course> findAllByTeacherId(Long teacherId);

    List<Course> findAllByTeacherUsername(String username);

    Long countAllByTeacherUserName(String username);

    List<Course> findAllByStudents(Long studentId);

    Course addTeacher(Long teacherId, Long id);

    Course addStudent(Long studentId, Long id);

    Course addStudents(List<Long> studentsId, Long id);

    Course addQuiz(Quiz quiz, Long id);

    Boolean existByCode(Integer code);

    void deleteStudent(Long courseId, Long studentId);
}
