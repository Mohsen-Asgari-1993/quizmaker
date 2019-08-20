package ir.maktab25.quizmaker.rest.base;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
import ir.maktab25.quizmaker.service.base.BaseQuestionService;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.Serializable;
import java.util.List;

public class BaseQuestionResource<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        Service extends BaseQuestionService<E, PK>, Mapper extends BaseMapper<E, D>>
        extends BaseRestFulService<E, D, PK, Service, Mapper> {

    public BaseQuestionResource(Service baseService, Mapper baseMapper) {
        super(baseService, baseMapper);
    }

    @GetMapping("/findAllTeacherQuestion")
    public ResponseEntity<List<D>> findAllTeacherQuestions(){
        List<E> list = baseService.findAllByTeacherUsername(CurrentUserDetail.getCurrentUsername());
        return ResponseEntity.ok(baseMapper.entityToDTOList(list));
    }

    @PostMapping("/addQuestion/{quizId}")
    public ResponseEntity<D> addQuestion(@PathVariable Long quizId, D d){
        E question = baseService.addQuestion(quizId, baseMapper.toEntity(d));
        return ResponseEntity.ok(baseMapper.toDTO(question));
    }
}
