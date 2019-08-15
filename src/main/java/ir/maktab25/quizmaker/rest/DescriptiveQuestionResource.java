package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.DescriptiveQuestion;
import ir.maktab25.quizmaker.rest.base.BaseQuestionResource;
import ir.maktab25.quizmaker.service.DescriptiveQuestionService;
import ir.maktab25.quizmaker.service.dto.DescriptiveQuestionDTO;
import ir.maktab25.quizmaker.service.mapper.DescriptiveQuestionMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/DescriptiveQuestion")
public class DescriptiveQuestionResource extends BaseQuestionResource<DescriptiveQuestion, DescriptiveQuestionDTO,
        Long, DescriptiveQuestionService, DescriptiveQuestionMapper> {

    public DescriptiveQuestionResource(DescriptiveQuestionService baseService, DescriptiveQuestionMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
