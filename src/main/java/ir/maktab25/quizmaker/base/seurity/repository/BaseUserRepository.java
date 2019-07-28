package ir.maktab25.quizmaker.base.seurity.repository;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    BaseUser findByUserName(String username);
}
