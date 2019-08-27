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

    @GetMapping("/teachers/{id}")
    public ResponseEntity<List<QuizDTO>> findAllByTeacherId(@PathVariable Long id) {
        List<Quiz> quizList = baseService.findAllByTeacherId(id);
        return ResponseEntity.ok(baseMapper.entityToDTOList(quizList));
    }

    @GetMapping("/numbers/teachers/username")
    public ResponseEntity<Long> countByTeacherUsername() {
        Long count = baseService.countByTeacherUsername();
        return ResponseEntity.ok(count);
    }

    @GetMapping("/numbers/students/username")
    public ResponseEntity<Long> countByStudentUsername() {
        Long count = baseService.countByStudentUsername();
        return ResponseEntity.ok(count);
    }

    @PostMapping("/{quizId}/questions")
    public ResponseEntity<QuizDTO> addQuestion(@PathVariable Long quizId, @RequestBody List<Long> questionIds) {
        Quiz quiz = baseService.addQuestion(quizId, questionIds);
        return ResponseEntity.ok(baseMapper.toDTO(quiz));
    }

    @GetMapping("/{quizId}/state/change")
    public ResponseEntity<QuizDTO> changeState(@PathVariable Long quizId) {
        Quiz quiz = baseService.changeState(quizId);
        return ResponseEntity.ok(baseMapper.toDTO(quiz));
    }

    @GetMapping("/questions/{questionId}")
    public ResponseEntity<List<QuizDTO>> findByQuestionId(@PathVariable Long questionId) {
        List<Quiz> quizzes = baseService.findAllByQuestionId(questionId);
        return ResponseEntity.ok(baseMapper.entityToDTOList(quizzes));
    }

    @DeleteMapping("/{quizId}/questions/{questionId}")
    public ResponseEntity<QuizDTO> deleteQuestion(@PathVariable Long quizId, @PathVariable Long questionId) {
        Quiz quiz = baseService.deleteQuestion(quizId, questionId);
        return ResponseEntity.ok(baseMapper.toDTO(quiz));
    }

}
