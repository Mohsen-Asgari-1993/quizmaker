package ir.maktab25.quizmaker.service.mapper.base;

import java.util.List;

public interface BaseMapper<E, D> {
    E toEntity(D d);

    D toDTO(E e);

    List<D> entityToDTOList(List<E> list);

    List<E> DTOtoEntityList(List<D> list);
}
