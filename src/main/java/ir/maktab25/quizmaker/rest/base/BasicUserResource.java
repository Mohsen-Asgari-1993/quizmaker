package ir.maktab25.quizmaker.rest.base;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.util.CurrentUserDetail;
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

    @GetMapping("/all/Enables")
    public ResponseEntity<List<D>> findAllEnables() {
        List<E> active = baseService.findAllByIsActive(true);
        return ResponseEntity.ok(baseMapper.entityToDTOList(active));
    }

    @GetMapping("/all/disables")
    public ResponseEntity<List<D>> findAllDisable() {
        List<E> disable = baseService.findAllByIsActive(false);
        return ResponseEntity.ok(baseMapper.entityToDTOList(disable));
    }

    @GetMapping("/numbers/all/enables")
    public ResponseEntity<Long> countAllEnables() {
        Long active = baseService.countAllByIsActive(true);
        return ResponseEntity.ok(active);
    }

    @GetMapping("/numbers/all/disables")
    public ResponseEntity<Long> countAllDisable() {
        Long all = baseService.countAllByIsActive(false);
        return ResponseEntity.ok(all);
    }

    @GetMapping("/all/role-name/{name}")
    public ResponseEntity<List<D>> findAllByRoleName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByRoleName(name)));
    }

    @GetMapping("/all/first-name/{name}")
    public ResponseEntity<List<D>> findAllByFirstName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByFirstName(name)));
    }

    @GetMapping("/all/last-name/{name}")
    public ResponseEntity<List<D>> findAllByLastName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByLastName(name)));
    }

    @GetMapping("/all/username")
    public ResponseEntity<D> findAllByUsername() {
        return ResponseEntity.ok(baseMapper.toDTO(baseService.findByUserName(CurrentUserDetail.getCurrentUsername())));
    }
}
