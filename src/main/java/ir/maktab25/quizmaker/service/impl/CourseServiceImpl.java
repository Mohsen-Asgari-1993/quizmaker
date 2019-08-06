package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
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

    private final Integer min = 10000;
    private final Integer max = 99999;

    public CourseServiceImpl(CourseRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Course save(Course t) {
        if (existByCode(t.getCode()))
            t.setCode(Integer.parseInt(findTop().getCode()) + 1 + "");
        return super.save(t);
    }

    @Override
    public List<Course> findAllByTeacher(Long teacher_id) {
        return baseRepository.findAllByTeacher_Id(teacher_id);
    }

    @Override
    public List<Course> findAllByStudents(User students) {
        return baseRepository.findAllByStudents(students);
    }

    @Override
    public Course addTeacher(User teacher, Long id) {
        Course course = baseRepository.getOne(id);
        if (checkTeacher(teacher)) {
            course.setTeacher(teacher);
            return super.save(course);
        } else {
            throw new RuntimeException("Cant add another role as teacher");
        }
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
    public Boolean existByCode(String code) {
        return baseRepository.existsByCode(code);
    }

    @Override
    public Course findTop() {
        return baseRepository.findTop();
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
