package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.MultipleChoiceQuestion;
import ir.maktab25.quizmaker.rest.base.BaseQuestionResource;
import ir.maktab25.quizmaker.service.MultipleChoiceQuestionService;
import ir.maktab25.quizmaker.service.dto.MultipleChoiceQuestionDTO;
import ir.maktab25.quizmaker.service.mapper.MultipleChoiceQuestionMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/MultipleChoiceQuestion")
public class MultipleChoiceQuestionResource extends
        BaseQuestionResource<MultipleChoiceQuestion,
                MultipleChoiceQuestionDTO,
                Long,
                MultipleChoiceQuestionService,
                MultipleChoiceQuestionMapper> {

    public MultipleChoiceQuestionResource(MultipleChoiceQuestionService baseService,
                                          MultipleChoiceQuestionMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
