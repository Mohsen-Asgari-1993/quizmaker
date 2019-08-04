package ir.maktab25.quizmaker.rest.base;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.service.base.BasicUserService;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;
import java.util.List;

public class BasicUserResource<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        Service extends BasicUserService<E, PK>, Mapper extends BaseMapper<E, D>>
        extends BaseRestFulService<E, D, PK, Service, Mapper> {

    public BasicUserResource(Service baseService, Mapper baseMapper) {
        super(baseService, baseMapper);
    }


    @GetMapping("/enable/{id}")
    public ResponseEntity<D> enableUser(@PathVariable PK id) {
        E e = baseService.enable(id);
        return ResponseEntity.ok(baseMapper.toDTO(e));
    }

    @GetMapping("/findAllEnable")
    public ResponseEntity<List<D>> findAllEnables() {
        List<E> active = baseService.findAllByIsActive(true);
        return ResponseEntity.ok(baseMapper.entityToDTOList(active));
    }

    @GetMapping("/findAllDisable")
    public ResponseEntity<List<D>> findAllDisable() {
        List<E> disable = baseService.findAllByIsActive(false);
        return ResponseEntity.ok(baseMapper.entityToDTOList(disable));
    }

    @GetMapping("/getAllByRoleName/{name}")
    public ResponseEntity<List<D>> findAllByRoleName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByRoleName(name)));
    }

    @GetMapping("/getAllByFirstName/{name}")
    public ResponseEntity<List<D>> findAllByFirstName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByFirstName(name)));
    }

    @GetMapping("/getAllByLastName/{name}")
    public ResponseEntity<List<D>> findAllByLastName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByLastName(name)));
    }
}
