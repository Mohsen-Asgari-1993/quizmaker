package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper extends BaseMapper<Course, CourseDTO> {

    @Override
    Course toEntity(CourseDTO courseDTO);

    @Override
    CourseDTO toDTO(Course course);

    @Override
    List<CourseDTO> entityToDTOList(List<Course> list);

    @Override
    List<Course> DTOtoEntityList(List<CourseDTO> list);
}
