package ir.maktab25.quizmaker.base.seurity.repository;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ir.maktab25.quizmaker.repository.base.UserRepository<User, Long> {

//    @Query("select u from User u left join fetch u.roles where u.userName = :username")

}
