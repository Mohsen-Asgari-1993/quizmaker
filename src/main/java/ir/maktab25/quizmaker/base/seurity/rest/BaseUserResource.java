package ir.maktab25.quizmaker.base.seurity.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.base.seurity.serivce.BaseUserService;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BaseUser")
public class BaseUserResource extends BaseRestFulService<BaseUser, BaseUserDTO, Long, BaseUserService, BaseUserMapper> {


    public BaseUserResource(BaseUserService baseService, BaseUserMapper baseMapper) {
        super(baseService, baseMapper);
    }


    @PostMapping("/teacher")
    public ResponseEntity<BaseUserDTO> createTeacher(@RequestBody BaseUserDTO userDTO) {
        if (userDTO.getId() != null) {
            return ResponseEntity
                    .badRequest()
                    .header("id exists", "A new entity cannot already have an ID")
                    .build();
        }
        BaseUser baseUser = baseService.saveTeacher(baseMapper.toEntity(userDTO));
        return ResponseEntity.ok(baseMapper.toDTO(baseUser));
    }

    @PostMapping("/student")
    public ResponseEntity<BaseUserDTO> createStudent(@RequestBody BaseUserDTO userDTO) {
        if (userDTO.getId() != null) {
            return ResponseEntity
                    .badRequest()
                    .header("id exists", "A new entity cannot already have an ID")
                    .build();
        }
        BaseUser baseUser = baseService.saveStudent(baseMapper.toEntity(userDTO));
        return ResponseEntity.ok(baseMapper.toDTO(baseUser));
    }

}
