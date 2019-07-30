package ir.maktab25.quizmaker.base.seurity.serivce;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;

public interface BaseUserService extends BaseService<BaseUser, Long> {

    BaseUser findByUserName(String username);

    BaseUser saveTeacher(BaseUser baseUser);

    BaseUser saveStudent(BaseUser baseUser);

}
