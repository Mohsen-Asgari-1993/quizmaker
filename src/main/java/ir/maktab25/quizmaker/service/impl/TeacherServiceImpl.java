package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.TeacherRepository;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.TeacherService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TeacherServiceImpl extends BasicUserServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {

    @Autowired
    RoleService roleService;

    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

    public TeacherServiceImpl(TeacherRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Teacher> findAllByCode(String code) {
        return baseRepository.findAllByCode(code);
    }

    @Override
    public Teacher changeRole(Teacher teacher) {
        Student student = studentService.findOne(teacher.getId());
        studentService.delete(teacher.getId());
        teacher.setId(null);
        teacher.setPassword(student.getPassword());
        teacher.setIsActive(student.getIsActive());
        setRole(teacher);
        return baseRepository.save(teacher);
    }

    @Override
    public Teacher save(Teacher t) {
        setRole(t);
        return super.save(t);
    }

    @Override
    public void delete(Long id) {
        List<Course> byTeacher = courseService.findAllByTeacher(id);
        for (Course course : byTeacher) {
            course.setTeacher(null);
            courseService.save(course);
        }

        super.delete(id);
    }

    private void setRole(Teacher teacher){
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(RoleName.TEACHER));
        teacher.setRoles(roles);
        if (teacher.getIsActive() == null)
            teacher.setIsActive(false);
    }
}
