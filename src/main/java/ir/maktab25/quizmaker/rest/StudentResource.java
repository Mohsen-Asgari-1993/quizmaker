package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.rest.base.BasicUserResource;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.mapper.StudentMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentResource extends BasicUserResource<Student, StudentDTO, Long, StudentService, StudentMapper> {

    public StudentResource(StudentService baseService, StudentMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @PostMapping("/role-change")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<StudentDTO> changeRole(@RequestBody StudentDTO studentDTO) {
        Student student = baseService.changeRole(baseMapper.toEntity(studentDTO));
        return ResponseEntity.ok(baseMapper.toDTO(student));
    }
}
