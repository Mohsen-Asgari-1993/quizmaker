package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.repository.UserRepository;
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
public class BaseUserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements BaseUserService {

    public BaseUserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public User findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }

    @Override
    public User enable(Long id) {
        User user = super.findOne(id);
        user.setIsActive(true);
        return super.save(user);
    }

    @Override
    public List<User> findAllByIsActive(Boolean isActive) {
        return baseRepository.findAllByIsActive(isActive);
    }

    @Override
    public List<User> findAllByRoleName(String roleName) {
        RoleName name = null;
        if (roleName.equalsIgnoreCase("teacher"))
            name = RoleName.TEACHER;
        if (roleName.equalsIgnoreCase("student"))
            name = RoleName.STUDENT;
        return baseRepository.findAllByRoles_RoleName(name);
    }

    @Override
    public List<User> findAllByFirstName(String firstName) {
        return baseRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<User> findAllByLastName(String lastName) {
        return baseRepository.findAllByLastName(lastName);
    }

    @Override
    public User save(User user) {
        checkRole(user);
        user.setIsActive(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return super.save(user);
    }

    private User setRole(User user, Role role) {
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        user.setRoles(roleSet);
        user.setIsActive(false);
        return super.save(user);
    }

    private void checkRole(User user) {
        user.getRoles().forEach(role -> {
            Set<Role> roles = new HashSet<>();
            if (role.getRoleName().equals(RoleName.STUDENT))
                roles.add(roleService.findByName(RoleName.STUDENT));
            else if (role.getRoleName().equals(RoleName.TEACHER))
                roles.add(roleService.findByName(RoleName.TEACHER));
            user.setRoles(roles);
        });
    }
}
