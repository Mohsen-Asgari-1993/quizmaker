package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.repository.UserRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public User findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }
}
