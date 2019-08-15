package ir.maktab25.quizmaker.repository.base;

import ir.maktab25.quizmaker.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface BaseQuestionRepository<E extends Question, PK extends Serializable> extends JpaRepository<E, PK> {

    List<E> findAllByTeacher_UserName(String username);
}
