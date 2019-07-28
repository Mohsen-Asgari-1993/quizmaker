package ir.maktab25.quizmaker.base.seurity.serivce;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;

public interface RoleService extends BaseService<Role, Long> {

    Role findByName(RoleName roleName);

}
