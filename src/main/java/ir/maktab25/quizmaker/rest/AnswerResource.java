package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.Answer;
import ir.maktab25.quizmaker.service.AnswerService;
import ir.maktab25.quizmaker.service.dto.AnswerDTO;
import ir.maktab25.quizmaker.service.mapper.AnswerMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Answer")
public class AnswerResource extends BaseRestFulService<Answer, AnswerDTO, Long, AnswerService, AnswerMapper> {

    public AnswerResource(AnswerService baseService, AnswerMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
