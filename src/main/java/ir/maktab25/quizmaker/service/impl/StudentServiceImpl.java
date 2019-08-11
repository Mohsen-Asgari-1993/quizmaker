package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.StudentRepository;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.TeacherService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl extends BasicUserServiceImpl<Student, Long, StudentRepository> implements StudentService {

    @Autowired
    RoleService roleService;

    @Autowired
    CourseService courseService;

    @Autowired
    TeacherService teacherService;

    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Student save(Student t) {
        setRole(t);
        return super.save(t);
    }

    @Override
    public void delete(Long id) {
        List<Course> courses = courseService.findAllByStudents(id);
        for (Course course : courses) {
            course.getStudents().removeIf(user -> user.getId().equals(id));
        }
        super.delete(id);
    }

    @Override
    public Student changeRole(Student student) {
        Teacher teacher = teacherService.findOne(student.getId());
        teacherService.delete(student.getId());
        student.setId(null);
        student.setPassword(teacher.getPassword());
        student.setIsActive(teacher.getIsActive());
        setRole(student);
        return baseRepository.save(student);
    }

    private void setRole(Student t) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(RoleName.STUDENT));
        t.setRoles(roles);
        if (t.getIsActive() == null)
            t.setIsActive(false);
    }
}
