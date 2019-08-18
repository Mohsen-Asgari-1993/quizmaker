package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.MultipleChoiceQuestion;
import ir.maktab25.quizmaker.service.dto.MultipleChoiceQuestionDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MultipleChoiceQuestionMapper extends BaseMapper<MultipleChoiceQuestion, MultipleChoiceQuestionDTO> {

    @Override
    MultipleChoiceQuestion toEntity(MultipleChoiceQuestionDTO multipleChoiceQuestionDTO);

    @Override
    MultipleChoiceQuestionDTO toDTO(MultipleChoiceQuestion multipleChoiceQuestion);

    @Override
    List<MultipleChoiceQuestionDTO> entityToDTOList(List<MultipleChoiceQuestion> list);

    @Override
    List<MultipleChoiceQuestion> DTOtoEntityList(List<MultipleChoiceQuestionDTO> list);
}
