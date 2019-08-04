package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<User, UserDTO> {

    @Override
    User toEntity(UserDTO userDTO);

    @Override
    UserDTO toDTO(User user);

    @Override
    List<UserDTO> entityToDTOList(List<User> list);

    @Override
    List<User> DTOtoEntityList(List<UserDTO> list);
}
