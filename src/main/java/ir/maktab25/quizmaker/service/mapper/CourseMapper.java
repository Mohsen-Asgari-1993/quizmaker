package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.service.dto.CouresDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper extends BaseMapper<Course, CouresDTO> {

    @Override
    Course toEntity(CouresDTO couresDTO);

    @Override
    CouresDTO toDTO(Course course);

    @Override
    List<CouresDTO> entityToDTOList(List<Course> list);

    @Override
    List<Course> DTOtoEntityList(List<CouresDTO> list);
}
