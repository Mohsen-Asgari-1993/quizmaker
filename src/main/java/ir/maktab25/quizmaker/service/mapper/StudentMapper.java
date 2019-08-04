package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentDTO> {

    @Override
    Student toEntity(StudentDTO studentDTO);

    @Override
    StudentDTO toDTO(Student student);

    @Override
    List<StudentDTO> entityToDTOList(List<Student> list);

    @Override
    List<Student> DTOtoEntityList(List<StudentDTO> list);
}
