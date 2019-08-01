package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.repository.BaseUserRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser, Long, BaseUserRepository> implements BaseUserService {

    public BaseUserServiceImpl(BaseUserRepository baseRepository) {
        super(baseRepository);
    }

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public BaseUser findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }

    @Override
    public BaseUser enable(Long id) {
        BaseUser baseUser = super.findOne(id);
        baseUser.setIsActive(true);
        return super.save(baseUser);
    }

    @Override
    public List<BaseUser> findAllByIsActive(Boolean isActive) {
        return baseRepository.findAllByIsActive(isActive);
    }

    @Override
    public BaseUser save(BaseUser baseUser) {
        checkRole(baseUser);
        baseUser.setIsActive(false);
        baseUser.setPassword(passwordEncoder.encode(baseUser.getPassword()));
        return super.save(baseUser);
    }

    private BaseUser setRole(BaseUser baseUser, Role role) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        baseUser.setRoles(roleSet);
        baseUser.setIsActive(false);
        return super.save(baseUser);
    }

    private void checkRole(BaseUser baseUser) {
        baseUser.getRoles().forEach(role -> {
            Set<Role> roles = new HashSet<>();
            if (role.getRoleName().equals(RoleName.STUDENT))
                roles.add(roleService.findByName(RoleName.STUDENT));
            else if (role.getRoleName().equals(RoleName.TEACHER))
                roles.add(roleService.findByName(RoleName.TEACHER));
            baseUser.setRoles(roles);
        });
    }
}
