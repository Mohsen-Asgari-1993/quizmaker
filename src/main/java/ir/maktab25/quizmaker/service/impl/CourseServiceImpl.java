package ir.maktab25.quizmaker.service.impl;

import com.fasterxml.jackson.databind.ser.Serializers;
import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
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
        if (checkTeacher(teacher)) {
            course.setTeacher(teacher);
            return super.save(course);
        } else {
            throw new RuntimeException("Cant add another role as teacher");
        }
    }

    @Override
    public Course addStudent(BaseUser student, Long id) {
        Course course = baseRepository.getOne(id);
        Set<BaseUser> courseStudents = course.getStudents();
        if (courseStudents == null)
            courseStudents = new HashSet<>();
        if (checkStudent(student))
            courseStudents.add(student);
        return super.save(course);
    }

    @Override
    public Course addStudents(Set<BaseUser> students, Long id) {
        Course course = baseRepository.getOne(id);
        Set<BaseUser> courseStudents = course.getStudents();
        if (courseStudents == null)
            courseStudents = new HashSet<>();
        for (BaseUser student: students){
            if (checkStudent(student))
                courseStudents.add(student);
        }
        return super.save(course);
    }

    private Boolean checkTeacher(BaseUser teacher) {
        Set<Role> roles = teacher.getRoles();
        for (Role r : roles) {
            if (r.getRoleName().equals(RoleName.TEACHER))
                return true;
        }
        return false;
    }

    private Boolean checkStudent(BaseUser teacher) {
        Set<Role> roles = teacher.getRoles();
        for (Role r : roles) {
            if (r.getRoleName().equals(RoleName.STUDENT))
                return true;
        }
        return false;
    }
}
