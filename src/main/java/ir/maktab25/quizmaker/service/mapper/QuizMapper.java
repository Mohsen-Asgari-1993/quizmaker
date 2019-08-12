package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuizMapper extends BaseMapper<Quiz, QuizDTO> {

    @Override
    Quiz toEntity(QuizDTO quizDTO);

    @Override
    QuizDTO toDTO(Quiz quiz);

    @Override
    List<QuizDTO> entityToDTOList(List<Quiz> list);

    @Override
    List<Quiz> DTOtoEntityList(List<QuizDTO> list);
}
