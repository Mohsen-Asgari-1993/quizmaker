package ir.maktab25.quizmaker.base.seurity.repository;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import ir.maktab25.quizmaker.repository.base.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseUserRepository extends UserRepository<BaseUser, Long> {

//    @Query("select u from BaseUser u left join fetch u.roles where u.userName = :username")

}
