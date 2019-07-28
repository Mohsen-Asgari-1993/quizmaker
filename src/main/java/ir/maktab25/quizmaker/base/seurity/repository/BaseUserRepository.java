package ir.maktab25.quizmaker.base.seurity.repository;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    @Query("select u from BaseUser u left join fetch u.roles where u.userName = :username")
    BaseUser findByUserName(@Param("username") String username);
}
