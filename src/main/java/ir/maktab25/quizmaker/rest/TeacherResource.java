package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.rest.base.BasicUserResource;
import ir.maktab25.quizmaker.service.TeacherService;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.mapper.TeacherMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Teacher")
public class TeacherResource extends BasicUserResource<Teacher, TeacherDTO, Long, TeacherService, TeacherMapper> {

    public TeacherResource(TeacherService baseService, TeacherMapper baseMapper) {
        super(baseService, baseMapper);
    }


    @PostMapping("/role-change")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<TeacherDTO> changeRole(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = baseService.changeRole(baseMapper.toEntity(teacherDTO));
        return ResponseEntity.ok(baseMapper.toDTO(teacher));
    }
}
