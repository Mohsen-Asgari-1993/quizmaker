package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.repository.StudentRepository;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class StudentServiceImpl extends BasicUserServiceImpl<Student, Long, StudentRepository> implements StudentService {

    @Autowired
    RoleService roleService;

    @Autowired
    CourseService courseService;

    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Student save(Student t) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(RoleName.STUDENT));
        t.setRoles(roles);
        if (t.getIsActive() == null)
            t.setIsActive(false);
        return super.save(t);
    }

    @Override
    public void delete(Long id) {
        List<Course> courses = courseService.findAllByStudents(id);
        for (Course course : courses) {
            for (User user : course.getStudents()){
                if (user.getId().equals(id))
                    course.getStudents().remove(user);
            }
        }
        super.delete(id);
    }
}
