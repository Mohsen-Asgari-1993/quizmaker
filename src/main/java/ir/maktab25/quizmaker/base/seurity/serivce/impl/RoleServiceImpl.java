package ir.maktab25.quizmaker.base.seurity.serivce.impl;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.repository.RoleRepository;
import ir.maktab25.quizmaker.base.seurity.serivce.RoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl extends BaseServiceImpl<Role, Long, RoleRepository> implements RoleService {

    public RoleServiceImpl(RoleRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public Role findByName(String name) {
        return baseRepository.findByRoleName(name);
    }
}
