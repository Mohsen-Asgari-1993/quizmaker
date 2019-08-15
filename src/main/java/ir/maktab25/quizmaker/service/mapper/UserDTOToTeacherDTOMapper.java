package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOToTeacherDTOMapper {

    TeacherDTO userDTOToTeacherDTO(UserDTO userDTO);
}
