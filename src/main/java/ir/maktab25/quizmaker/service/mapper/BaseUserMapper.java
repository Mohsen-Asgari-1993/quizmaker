package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseUserMapper extends BaseMapper<User, BaseUserDTO> {

    @Override
    User toEntity(BaseUserDTO baseUserDTO);

    @Override
    BaseUserDTO toDTO(User user);

    @Override
    List<BaseUserDTO> entityToDTOList(List<User> list);

    @Override
    List<User> DTOtoEntityList(List<BaseUserDTO> list);
}
