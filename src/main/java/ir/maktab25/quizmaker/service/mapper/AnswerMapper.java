package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Answer;
import ir.maktab25.quizmaker.service.dto.AnswerDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnswerMapper extends BaseMapper<Answer, AnswerDTO> {

    @Override
    Answer toEntity(AnswerDTO answerDTO);

    @Override
    AnswerDTO toDTO(Answer answer);

    @Override
    List<AnswerDTO> entityToDTOList(List<Answer> list);

    @Override
    List<Answer> DTOtoEntityList(List<AnswerDTO> list);
}
