package ir.maktab25.quizmaker.base.seurity.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.BaseUserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BaseUser")
public class BaseUserResource extends BaseRestFulService<BaseUser, BaseUserDTO, Long, BaseUserService, BaseUserMapper> {


    public BaseUserResource(BaseUserService baseService, BaseUserMapper baseMapper) {
        super(baseService, baseMapper);
    }


    @PostMapping("/save")
    public ResponseEntity<BaseUserDTO> createUser(@RequestBody BaseUserDTO userDTO) {
        if (userDTO.getId() != null) {
            return ResponseEntity
                    .badRequest()
                    .header("id exists", "A new entity cannot already have an ID")
                    .build();
        }
        BaseUser baseUser = baseService.save(baseMapper.toEntity(userDTO));
        return ResponseEntity.ok(baseMapper.toDTO(baseUser));
    }

    @GetMapping("/enable/{id}")
    public ResponseEntity<BaseUserDTO> enableUser(@PathVariable Long id) {
        BaseUser baseUser = baseService.enable(id);
        return ResponseEntity.ok(baseMapper.toDTO(baseUser));
    }

    @GetMapping("/findAllEnable")
    public ResponseEntity<List<BaseUserDTO>> findAllEnables() {
        List<BaseUser> active = baseService.findAllByIsActive(true);
        return ResponseEntity.ok(baseMapper.entityToDTOList(active));
    }

    @GetMapping("/findAllDisable")
    public ResponseEntity<List<BaseUserDTO>> findAllDisable() {
        List<BaseUser> disable = baseService.findAllByIsActive(false);
        return ResponseEntity.ok(baseMapper.entityToDTOList(disable));
    }

    @GetMapping("/getAllByRoleName/{name}")
    public ResponseEntity<List<BaseUserDTO>> findAllByRoleName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByRoleName(name)));
    }

    @GetMapping("/getAllByFirstName/{name}")
    public ResponseEntity<List<BaseUserDTO>> findAllByFirstName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByFirstName(name)));
    }

    @GetMapping("/getAllByLastName/{name}")
    public ResponseEntity<List<BaseUserDTO>> findAllByLastName(@PathVariable String name) {
        return ResponseEntity.ok(baseMapper.entityToDTOList(baseService.findAllByLastName(name)));
    }
}
