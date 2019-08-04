package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.repository.UserRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BasicUserServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }
}
