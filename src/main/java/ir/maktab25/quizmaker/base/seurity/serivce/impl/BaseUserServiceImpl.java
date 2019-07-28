package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.repository.BaseUserRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BaseUserServiceImpl extends BaseServiceImpl<BaseUser, Long, BaseUserRepository> implements BaseUserService {

    public BaseUserServiceImpl(BaseUserRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public BaseUser findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }
}
