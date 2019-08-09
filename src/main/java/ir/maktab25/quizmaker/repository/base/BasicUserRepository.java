package ir.maktab25.quizmaker.repository.base;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BasicUserRepository<E extends User, PK extends Serializable> extends JpaRepository<E, PK> {

    E findByUserName(String username);

    List<E> findAllByIsActive(Boolean isActive);

    List<E> findAllByRoles_RoleName(RoleName roleName);

    List<E> findAllByFirstName(String firstName);

    List<E> findAllByLastName(String lastName);

    Long countAllByIsActive(Boolean isActive);
}
