package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.service.QuizService;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import ir.maktab25.quizmaker.service.mapper.QuizMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Quiz")
public class QuizResource extends BaseRestFulService<Quiz, QuizDTO, Long, QuizService, QuizMapper> {

    public QuizResource(QuizService baseService, QuizMapper baseMapper) {
        super(baseService, baseMapper);
    }
}
