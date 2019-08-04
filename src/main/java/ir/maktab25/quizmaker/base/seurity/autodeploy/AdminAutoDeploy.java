package ir.maktab25.quizmaker.base.seurity.autodeploy;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class AdminAutoDeploy {

    @Autowired
    BaseUserService baseUserService;

    @Autowired
    RoleService roleService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostConstruct
    public void initialize() {
        if (roleService.findByName(RoleName.ADMIN) == null)
            roleService.save(new Role(null, RoleName.ADMIN, null));
        if (roleService.findByName(RoleName.SUPER) == null)
            roleService.save(new Role(null, RoleName.SUPER, null));
        if (roleService.findByName(RoleName.TEACHER) == null)
            roleService.save(new Role(null, RoleName.TEACHER, null));
        if (roleService.findByName(RoleName.STUDENT) == null)
            roleService.save(new Role(null, RoleName.STUDENT, null));

        userDeploy("admin", "admin", true, RoleName.ADMIN);
        userDeploy("super", "super", true, RoleName.SUPER);
        userDeploy("st", "st", false, RoleName.STUDENT);

    }

    private void userDeploy(String username, String password, boolean active, RoleName roleName) {
        User user = baseUserService.findByUserName(username);
        if (user == null) {
            user = new User();
            user.setUserName(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setIsActive(active);
            Set<Role> roles = new HashSet<>();
            Role name = roleService.findByName(roleName);
            roles.add(name);
            user.setRoles(roles);
            baseUserService.save(user);
        }
    }
}
