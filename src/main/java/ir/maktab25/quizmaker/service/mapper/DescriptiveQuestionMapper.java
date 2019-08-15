package ir.maktab25.quizmaker.service.mapper;

import ir.maktab25.quizmaker.domain.DescriptiveQuestion;
import ir.maktab25.quizmaker.service.dto.DescriptiveQuestionDTO;
import ir.maktab25.quizmaker.service.mapper.base.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DescriptiveQuestionMapper extends BaseMapper<DescriptiveQuestion, DescriptiveQuestionDTO> {
}
