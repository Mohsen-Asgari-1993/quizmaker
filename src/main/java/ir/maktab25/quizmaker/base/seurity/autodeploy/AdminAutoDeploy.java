package ir.maktab25.quizmaker.base.seurity.autodeploy;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
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
        Role admin = roleService.findByName(RoleName.ROLE_ADMIN);
        Role superUser = roleService.findByName(RoleName.ROLE_SUPER);
        if (admin == null)
            admin = roleService.save(new Role(null, RoleName.ROLE_ADMIN, null));
        if (superUser == null)
            superUser = roleService.save(new Role(null, RoleName.ROLE_SUPER, null));
        if (roleService.findByName(RoleName.ROLE_TEACHER) == null)
            roleService.save(new Role(null, RoleName.ROLE_TEACHER, null));
        if (roleService.findByName(RoleName.ROLE_STUDENT) == null)
            roleService.save(new Role(null, RoleName.ROLE_STUDENT, null));

        BaseUser roleAdmin = baseUserService.findByUserName("admin");
        if (roleAdmin == null) {
            roleAdmin = new BaseUser();
            roleAdmin.setUserName("admin");
            roleAdmin.setPassword(passwordEncoder.encode("maktab25"));
            roleAdmin.setIsActive(true);
            Set<Role> roles = new HashSet<>();
            roles.add(admin);
            roleAdmin.setRoles(roles);
            baseUserService.save(roleAdmin);
        }

        BaseUser roleSuper = baseUserService.findByUserName("superUser");
        if (roleSuper == null) {
            roleSuper = new BaseUser();
            roleSuper.setUserName("superUser");
            roleSuper.setPassword(passwordEncoder.encode("superUser"));
            roleSuper.setIsActive(true);
            Set<Role> roles = new HashSet<>();
            roles.add(superUser);
            roleSuper.setRoles(roles);
            baseUserService.save(roleSuper);
        }

        BaseUser roleSt = baseUserService.findByUserName("st");
        if (roleSt == null) {
            roleSt = new BaseUser();
            roleSt.setUserName("st");
            roleSt.setPassword(passwordEncoder.encode("student25"));
            roleSt.setIsActive(false);
            Set<Role> roles = new HashSet<>();
            roles.add(roleService.findByName(RoleName.ROLE_STUDENT));
            roleSt.setRoles(roles);
            baseUserService.save(roleSt);
        }
    }
}
