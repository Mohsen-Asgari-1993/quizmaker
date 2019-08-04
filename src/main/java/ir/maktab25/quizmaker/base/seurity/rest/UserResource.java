package ir.maktab25.quizmaker.base.seurity.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.BaseUserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BaseUser")
public class UserResource extends BaseRestFulService<User, BaseUserDTO, Long, UserService, BaseUserMapper> {


    public UserResource(UserService baseService, BaseUserMapper baseMapper) {
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
        User user = baseService.save(baseMapper.toEntity(userDTO));
        return ResponseEntity.ok(baseMapper.toDTO(user));
    }

    @GetMapping("/enable/{id}")
    public ResponseEntity<BaseUserDTO> enableUser(@PathVariable Long id) {
        User user = baseService.enable(id);
        return ResponseEntity.ok(baseMapper.toDTO(user));
    }

    @GetMapping("/findAllEnable")
    public ResponseEntity<List<BaseUserDTO>> findAllEnables() {
        List<User> active = baseService.findAllByIsActive(true);
        return ResponseEntity.ok(baseMapper.entityToDTOList(active));
    }

    @GetMapping("/findAllDisable")
    public ResponseEntity<List<BaseUserDTO>> findAllDisable() {
        List<User> disable = baseService.findAllByIsActive(false);
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
