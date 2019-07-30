package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.repository.CourseRepository;
import ir.maktab25.quizmaker.service.CourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("CourseServiceImpl")
@Transactional
public class CourseServiceImpl extends BaseServiceImpl<Course, Long, CourseRepository> implements CourseService {

    public CourseServiceImpl(CourseRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Course> findAllByTeacher(Long teacher_id) {
        return baseRepository.findAllByTeacher_Id(teacher_id);
    }

    @Override
    public List<Course> findAllByStudents(BaseUser students) {
        return baseRepository.findAllByStudents(students);
    }

    @Override
    public Course addTeacher(BaseUser teacher, Long id) {
        Course course = baseRepository.getOne(id);
        course.setTeacher(teacher);
        return super.save(course);
    }

    @Override
    public Course addStudent(BaseUser student, Long id) {
        Course course = baseRepository.getOne(id);
        Set<BaseUser> students = course.getStudents();
        if (student == null)
            students = new HashSet<>();
        students.add(student);
        return super.save(course);
    }

    @Override
    public Course addStudents(Set<BaseUser> students, Long id) {
        Course course = baseRepository.getOne(id);
        Set<BaseUser> couresStudents = course.getStudents();
        if (couresStudents == null)
            couresStudents = new HashSet<>();
        couresStudents.addAll(students);
        return super.save(course);
    }
}
