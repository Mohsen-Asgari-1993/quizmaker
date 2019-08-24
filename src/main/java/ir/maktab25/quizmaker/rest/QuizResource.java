package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.Quiz;
import ir.maktab25.quizmaker.service.QuizService;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import ir.maktab25.quizmaker.service.mapper.QuizMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/countByTeacherId")
    public ResponseEntity<Long> countByTeacherUsername() {
        Long count = baseService.countByTeacherUsername();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/addQuestion/{quizId}")
    public ResponseEntity<QuizDTO> addQuestion(@PathVariable Long quizId, @RequestBody List<Long> questionIds){
        Quiz quiz = baseService.addQuestion(quizId, questionIds);
        return ResponseEntity.ok(baseMapper.toDTO(quiz));
    }
}
