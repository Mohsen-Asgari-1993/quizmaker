package ir.maktab25.quizmaker.base.seurity.repository;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(RoleName roleName);
}
