package ir.maktab25.quizmaker.rest;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.dto.QuizDTO;
import ir.maktab25.quizmaker.service.mapper.CourseMapper;
import ir.maktab25.quizmaker.service.mapper.QuizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Course")
public class CourseResource extends BaseRestFulService<Course, CourseDTO, Long, CourseService, CourseMapper> {


    @Autowired
    QuizMapper quizMapper;

    public CourseResource(CourseService baseService, CourseMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @GetMapping("/findByTeacher/{id}")
    public ResponseEntity<List<CourseDTO>> findAllByTeacherId(@PathVariable("id") Long id) {
        List<Course> courses = baseService.findAllByTeacherId(id);
        if (courses == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(baseMapper.entityToDTOList(courses));
    }

    @GetMapping("/findByTeacherUsername/{username}")
    public ResponseEntity<List<CourseDTO>> findAllByTeacherUserName(@PathVariable("username") String username) {
        List<Course> courses = baseService.findAllByTeacherUsername(username);
        if (courses == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(baseMapper.entityToDTOList(courses));
    }

    @GetMapping("/countByTeacherUsername/{username}")
    public ResponseEntity<Long> countByTeacherUserName(@PathVariable("username") String username) {
        Long count = baseService.countAllByTeacherUserName(username);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/findByStudent/{id}")
    public ResponseEntity<List<CourseDTO>> findAllByStudents(@PathVariable Long id) {
        List<Course> courses = baseService.findAllByStudents(id);
        if (courses == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(baseMapper.entityToDTOList(courses));
    }

    @PostMapping("/addTeacher/{courseId}/{teacherId}")
    public ResponseEntity<CourseDTO> addTeacher(@PathVariable Long teacherId, @PathVariable("courseId") Long id) {
        Course course = baseService.addTeacher(teacherId, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @GetMapping("/addSingleStudent/{courseId}/{studentId}")
    public ResponseEntity<CourseDTO> addStudent(@PathVariable("courseId") Long id, @PathVariable Long studentId) {
        Course course = baseService.addStudent(studentId, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @PostMapping("/addStudents/{courseId}")
    public ResponseEntity<CourseDTO> addStudents(@RequestBody List<Long> studentsId, @PathVariable("courseId") Long id) {
        Course course = baseService.addStudents(studentsId, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @PostMapping("/addQuiz/{courseId}")
    public ResponseEntity<CourseDTO> addQuiz(@RequestBody QuizDTO quizDTO, @PathVariable("courseId") Long id) {
        Course course = baseService.addQuiz(quizMapper.toEntity(quizDTO), id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @DeleteMapping("/deleteStudent/{courseId}/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        baseService.deleteStudent(courseId, studentId);
        return ResponseEntity.ok().header("deleted", "successful").build();
    }

    @DeleteMapping("/deleteQuiz/{courseId}/{quizId}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long courseId, @PathVariable Long quizId) {
        baseService.deleteQuiz(courseId, quizId);
        return ResponseEntity.ok().header("deleted", "successful").build();
    }

    @GetMapping("/countAll")
    public ResponseEntity<Long> countAll() {
        return ResponseEntity.ok(baseService.countAll());
    }
}
