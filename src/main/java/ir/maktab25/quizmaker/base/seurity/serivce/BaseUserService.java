package ir.maktab25.quizmaker.base.seurity.serivce;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;

import java.util.List;

public interface BaseUserService extends BaseService<BaseUser, Long> {

    BaseUser findByUserName(String username);

    BaseUser enable(Long id);

    List<BaseUser> findAllByIsActive(Boolean isActive);


    List<BaseUser> findAllByRoleName(String roleName);

    List<BaseUser> findAllByFirstName(String firstName);

    List<BaseUser> findAllByLastName(String lastName);

}
