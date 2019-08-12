package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.service.QuizService;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import ir.maktab25.quizmaker.service.mapper.QuizMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
public class QuizResource extends BaseRestFulService<Quiz, QuizDTO, Long, QuizService, QuizMapper> {

    public QuizResource(QuizService baseService, QuizMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @GetMapping("/findAllByTeacherId/{id}")
    public ResponseEntity<List<QuizDTO>> findAllByTeacherId(@PathVariable Long id) {
        List<Quiz> quizList = baseService.findAllByTeacherId(id);
        return ResponseEntity.ok(baseMapper.entityToDTOList(quizList));
    }
}
