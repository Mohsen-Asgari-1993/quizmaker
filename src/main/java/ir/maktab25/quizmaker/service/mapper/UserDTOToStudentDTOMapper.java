package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDTOToStudentDTOMapper{

    StudentDTO userDTOToStudentDTO(UserDTO userDTO);
}
