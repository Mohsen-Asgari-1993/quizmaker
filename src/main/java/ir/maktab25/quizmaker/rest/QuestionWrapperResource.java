package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import ir.maktab25.quizmaker.service.QuestionWrapperService;
import ir.maktab25.quizmaker.service.dto.QuestionWrapperDTO;
import ir.maktab25.quizmaker.service.mapper.QuestionWrapperMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/QuestionWrapper")
public class QuestionWrapperResource extends
        BaseRestFulService<QuestionWrapper, QuestionWrapperDTO, Long, QuestionWrapperService, QuestionWrapperMapper> {

    public QuestionWrapperResource(QuestionWrapperService baseService, QuestionWrapperMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
