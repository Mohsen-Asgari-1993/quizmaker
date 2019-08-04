package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.rest.base.BasicUserResource;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.mapper.StudentMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentResource extends BasicUserResource<Student, StudentDTO, Long, StudentService, StudentMapper> {

    public StudentResource(StudentService baseService, StudentMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
