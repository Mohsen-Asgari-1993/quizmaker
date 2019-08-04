package ir.maktab25.quizmaker.service.impl.base;

import ir.maktab25.quizmaker.base.service.impl.BaseServiceImpl;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.repository.base.BasicUserRepository;
import ir.maktab25.quizmaker.service.base.BasicUserService;

import java.io.Serializable;
import java.util.List;

public class BasicUserServiceImpl<E extends User, PK extends Serializable, Repo extends BasicUserRepository<E, PK>>
        extends BaseServiceImpl<E, PK, Repo> implements BasicUserService<E, PK> {

    public BasicUserServiceImpl(Repo baseRepository) {
        super(baseRepository);
    }

    @Override
    public E findByUserName(String username) {
        return baseRepository.findByUserName(username);
    }

    @Override
    public E enable(PK id) {
        E e = baseRepository.getOne(id);
        e.setIsActive(true);
        return super.save(e);
    }

    @Override
    public List<E> findAllByIsActive(Boolean isActive) {
        return baseRepository.findAllByIsActive(isActive);
    }

    @Override
    public List<E> findAllByRoleName(String roleName) {
        RoleName name = null;
        if (RoleName.STUDENT.toString().equalsIgnoreCase("student"))
            name = RoleName.STUDENT;
        else if (RoleName.TEACHER.toString().equalsIgnoreCase("teacher"))
            name = RoleName.TEACHER;
        return baseRepository.findAllByRoles_RoleName(name);
    }

    @Override
    public List<E> findAllByFirstName(String firstName) {
        return baseRepository.findAllByFirstName(firstName);
    }

    @Override
    public List<E> findAllByLastName(String lastName) {
        return baseRepository.findAllByLastName(lastName);
    }
}
