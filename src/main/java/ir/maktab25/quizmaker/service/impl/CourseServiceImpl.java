package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.CourseRepository;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @Override
    public Course save(Course t) {
        if (t.getId() != null){
            t.setTeacher(findOne(t.getId()).getTeacher());
            t.setStudents(findOne(t.getId()).getStudents());
        }
        return super.save(t);
    }

    @Override
    public List<Course> findAllByTeacher(Long teacherId) {
        return baseRepository.findAllByTeacher_Id(teacherId);
    }

    @Override
    public List<Course> findAllByStudents(Long studentId) {
        return baseRepository.findAllByStudents(studentService.findOne(studentId));
    }

    @Override
    public Course addTeacher(Long teacherId, Long id) {
        Course course = baseRepository.getOne(id);
        Teacher teacher = teacherService.findOne(teacherId);
        course.setTeacher(teacher);
        return super.save(course);
    }

    @Override
    public Course addStudent(User student, Long id) {
        Course course = baseRepository.getOne(id);
        Set<User> courseStudents = course.getStudents();
        if (courseStudents == null)
            courseStudents = new HashSet<>();
        if (checkStudent(student))
            courseStudents.add(student);
        return super.save(course);
    }

    @Override
    public Course addStudents(Set<User> students, Long id) {
        Course course = baseRepository.getOne(id);
        Set<User> courseStudents = course.getStudents();
        if (courseStudents == null)
            courseStudents = new HashSet<>();
        for (User student : students) {
            if (checkStudent(student))
                courseStudents.add(student);
        }
        return super.save(course);
    }

    @Override
    public Boolean existByCode(Integer code) {
        return baseRepository.existsByCode(code);
    }

    private Boolean checkTeacher(User teacher) {
        Set<Role> roles = teacher.getRoles();
        for (Role r : roles) {
            if (r.getRoleName().equals(RoleName.TEACHER))
                return true;
        }
        return false;
    }

    private Boolean checkStudent(User teacher) {
        Set<Role> roles = teacher.getRoles();
        for (Role r : roles) {
            if (r.getRoleName().equals(RoleName.STUDENT))
                return true;
        }
        return false;
    }
}
