package ir.maktab25.quizmaker.rest.base;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.service.base.BaseQuestionService;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;

import java.io.Serializable;

public class BaseQuestionResource<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        Service extends BaseQuestionService<E, PK>, Mapper extends BaseMapper<E, D>>
        extends BaseRestFulService<E, D, PK, Service, Mapper> {

    public BaseQuestionResource(Service baseService, Mapper baseMapper) {
        super(baseService, baseMapper);
    }
}
