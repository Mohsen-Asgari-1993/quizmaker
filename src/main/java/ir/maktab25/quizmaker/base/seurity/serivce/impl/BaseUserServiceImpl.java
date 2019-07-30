package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.repository.BaseUserRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser, Long, BaseUserRepository> implements BaseUserService {

    public BaseUserServiceImpl(BaseUserRepository baseRepository) {
        super(baseRepository);
    }

    @Autowired
    RoleService roleService;

    @Override
    public BaseUser findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }

    @Override
    public BaseUser saveTeacher(BaseUser baseUser) {
        Role role = roleService.findByName(RoleName.TEACHER);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        baseUser.setRoles(roleSet);
        return super.save(baseUser);
    }

    @Override
    public BaseUser saveStudent(BaseUser baseUser) {
        Role role = roleService.findByName(RoleName.STUDENT);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        baseUser.setRoles(roleSet);
        return super.save(baseUser);
    }
}
