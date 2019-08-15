package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.domain.Question;
import ir.maktab25.quizmaker.rest.base.BaseQuestionResource;
import ir.maktab25.quizmaker.service.QuestionService;
import ir.maktab25.quizmaker.service.dto.QuestionDTO;
import ir.maktab25.quizmaker.service.mapper.QuestionMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Question")
public class QuestionResource extends BaseQuestionResource<Question, QuestionDTO, Long, QuestionService, QuestionMapper> {

    public QuestionResource(QuestionService baseService, QuestionMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
