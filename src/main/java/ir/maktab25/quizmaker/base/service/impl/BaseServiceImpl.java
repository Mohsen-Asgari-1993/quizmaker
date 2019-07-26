package ir.maktab25.quizmaker.base.service.impl;

import ir.maktab25.quizmaker.base.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<E, PK extends Serializable, Repository extends JpaRepository<E, PK>>
        implements BaseService<E, PK> {

    protected final Repository baseRepository;
    protected Class<E> entityClass;

    public BaseServiceImpl(Repository baseRepository) {
        this.baseRepository = baseRepository;
    }

    @Override
    public E save(E t) {
        return baseRepository.save(t);
    }

    @Override
    public Page<E> findAll(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    @Override
    public List<E> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public E findOne(PK id) {
        return baseRepository.getOne(id);
    }

    @Override
    public void delete(PK id) {
        baseRepository.deleteById(id);
    }

    @Override
    public Long countAll() {
        return baseRepository.count();
    }
}
