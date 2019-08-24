package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.service.dto.QuestionWrapperDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionWrapperMapper extends BaseMapper<QuestionWrapper, QuestionWrapperDTO> {

    @Override
    QuestionWrapper toEntity(QuestionWrapperDTO questionWrapperDTO);

    @Override
    QuestionWrapperDTO toDTO(QuestionWrapper questionWrapper);

    @Override
    List<QuestionWrapperDTO> entityToDTOList(List<QuestionWrapper> list);

    @Override
    List<QuestionWrapper> DTOtoEntityList(List<QuestionWrapperDTO> list);
}
