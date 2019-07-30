package ir.maktab25.quizmaker.base.rest;

import io.swagger.annotations.ApiParam;
import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.service.BaseService;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class BaseRestFulService<E extends BaseEntity<PK>, D extends BaseDTO<PK>, PK extends Serializable,
        Service extends BaseService<E, PK>> {

    private final Service baseService;
    private BaseMapper<E, D> baseMapper;

    public BaseRestFulService(Service baseService) {
        this.baseService = baseService;
    }

    @PostMapping
    public ResponseEntity<D> create(@RequestBody D d) {
        if (d.getId() != null) {
            return ResponseEntity
                    .badRequest()
                    .header("id exists", "A new entity cannot already have an ID")
                    .build();
        }
        E e = baseService.save(baseMapper.toEntity(d));
        return ResponseEntity.ok(baseMapper.toDTO(e));
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D d) {
        if (d.getId() == null) {
            return ResponseEntity
                    .badRequest()
                    .header("id is null", "entity must have an ID to update")
                    .build();
        }
        E e = baseService.save(baseMapper.toEntity(d));
        return ResponseEntity.ok(baseMapper.toDTO(e));
    }

    @GetMapping("/pageable")
    public ResponseEntity<List<D>> getAll(@ApiParam Pageable pageable) {
        Page<E> page = baseService.findAll(pageable);
        return ResponseEntity.ok(baseMapper.entityToDTOList(page.getContent()));
    }

    @GetMapping
    public ResponseEntity<List<D>> getAllNotPageable() {
        List<E> page = baseService.findAll();
        return ResponseEntity.ok(baseMapper.entityToDTOList(page));
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable PK id) {
        E e = baseService.findOne(id);
        if (e != null)
            return ResponseEntity.ok(baseMapper.toDTO(e));
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable PK id) {
        baseService.delete(id);
        return ResponseEntity.ok().header("deleted", "successful").build();
    }

}
