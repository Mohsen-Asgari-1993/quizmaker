package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper extends BaseMapper<Teacher, TeacherDTO> {

    @Override
    Teacher toEntity(TeacherDTO teacherDTO);

    @Override
    TeacherDTO toDTO(Teacher teacher);

    @Override
    List<TeacherDTO> entityToDTOList(List<Teacher> list);

    @Override
    List<Teacher> DTOtoEntityList(List<TeacherDTO> list);
}
