package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseUserMapper extends BaseMapper<BaseUser, BaseUserDTO> {

    @Override
    BaseUser toEntity(BaseUserDTO baseUserDTO);

    @Override
    BaseUserDTO toDTO(BaseUser baseUser);

    @Override
    List<BaseUserDTO> entityToDTOList(List<BaseUser> list);

    @Override
    List<BaseUser> DTOtoEntityList(List<BaseUserDTO> list);
}
