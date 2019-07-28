package ir.maktab25.quizmaker.base.seurity.serivce;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.Role;

public interface RoleService extends BaseService<Role, Long> {

    Role findByName(String name);

}
