package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.base.seurity.domian.Role;
import ir.maktab25.quizmaker.service.dto.RoleDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<Role, RoleDTO> {

    @Mapping(target = "users")
    @Override
    Role toEntity(RoleDTO roleDTO);

    @Override
    RoleDTO toDTO(Role role);

    @Override
    List<RoleDTO> entityToDTOList(List<Role> list);

    @Override
    List<Role> DTOtoEntityList(List<RoleDTO> list);
}
