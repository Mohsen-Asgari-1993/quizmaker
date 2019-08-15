package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.service.dto.QuestionDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper extends BaseMapper<Question, QuestionDTO> {

    @Override
    Question toEntity(QuestionDTO questionDTO);

    @Override
    QuestionDTO toDTO(Question question);

    @Override
    List<QuestionDTO> entityToDTOList(List<Question> list);

    @Override
    List<Question> DTOtoEntityList(List<QuestionDTO> list);
}
