package ir.maktab25.quizmaker.base.seurity.serivce;

import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.base.seurity.domian.User;

public interface UserService extends BaseService<User, Long> {

    User findByUserName(String username);

}
