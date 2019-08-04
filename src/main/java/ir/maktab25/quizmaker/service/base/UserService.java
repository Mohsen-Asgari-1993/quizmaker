package ir.maktab25.quizmaker.service.base;

import ir.maktab25.quizmaker.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface UserService<E, PK extends Serializable> extends BaseService<E, PK> {
    E findByUserName(String username);

    E enable(PK id);

    List<E> findAllByIsActive(Boolean isActive);


    List<E> findAllByRoleName(String roleName);

    List<E> findAllByFirstName(String firstName);

    List<E> findAllByLastName(String lastName);

}
