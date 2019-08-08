package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.TeacherRepository;
import ir.maktab25.quizmaker.service.CourseService;
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

    public TeacherServiceImpl(TeacherRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Teacher> findAllByCode(String code) {
        return baseRepository.findAllByCode(code);
    }

    @Override
    public Teacher save(Teacher t) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByName(RoleName.TEACHER));
        t.setRoles(roles);
        if (t.getIsActive() == null)
            t.setIsActive(false);
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
}
