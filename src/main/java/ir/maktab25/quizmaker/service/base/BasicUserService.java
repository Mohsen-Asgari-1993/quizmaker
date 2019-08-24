package ir.maktab25.quizmaker.service.base;

import ir.maktab25.quizmaker.base.service.BaseService;

import java.io.Serializable;
import java.util.List;

public interface BasicUserService<E, PK extends Serializable> extends BaseService<E, PK> {
    E findByUserName();

    E enable(PK id);

    List<E> findAllByIsActive(Boolean isActive);


    List<E> findAllByRoleName(String roleName);

    List<E> findAllByFirstName(String firstName);

    List<E> findAllByLastName(String lastName);

    Long countAllByIsActive(Boolean isActive);

}
