package ir.maktab25.quizmaker.base.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T, PK extends Serializable>  {

    T save(T t);

    Page<T> findAll(Pageable pageable);

    List<T> findAll();

    T findOne(PK id);

    void delete(PK id);

    Long countAll();

}
