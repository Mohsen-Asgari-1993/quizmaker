package ir.maktab25.quizmaker.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E, PK extends Serializable>  {

    E save(E t);

    Page<E> findAll(Pageable pageable);

    List<E> findAll();

    E findOne(PK id);

    void delete(PK id);

    Long countAll();

}
