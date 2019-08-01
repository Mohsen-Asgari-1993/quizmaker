package ir.maktab25.quizmaker.resource;

import ir.maktab25.quizmaker.base.rest.BaseRestFulService;
import ir.maktab25.quizmaker.base.seurity.domian.BaseUser;
import ir.maktab25.quizmaker.domain.Course;
import ir.maktab25.quizmaker.service.CourseService;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.mapper.CourseMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/Course")
public class CourseResource extends BaseRestFulService<Course, CourseDTO, Long, CourseService, CourseMapper> {


    public CourseResource(CourseService baseService, CourseMapper baseMapper) {
        super(baseService, baseMapper);
    }

    @GetMapping("/findByTeacher/{id}")
    public ResponseEntity<List<CourseDTO>> findAllByTeacher(@PathVariable("id") Long id) {
        List<Course> courses = baseService.findAllByTeacher(id);
        if (courses == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(baseMapper.entityToDTOList(courses));
    }

    @PostMapping("/findByStudent")
    public ResponseEntity<List<CourseDTO>> findAllByStudents(@RequestBody BaseUser students) {
        List<Course> courses = baseService.findAllByStudents(students);
        if (courses == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(baseMapper.entityToDTOList(courses));
    }

    @PostMapping("/addTeacher/{courseId}")
    public ResponseEntity<CourseDTO> addTeacher(@RequestBody BaseUser teacher, @PathVariable("courseId") Long id) {
        Course course = baseService.addTeacher(teacher, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @PostMapping("/addSingleStudent/{courseId}")
    public ResponseEntity<CourseDTO> addStudent(@RequestBody BaseUser student, @PathVariable("courseId") Long id) {
        Course course = baseService.addStudent(student, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }

    @PostMapping("/addStudents/{courseId}")
    public ResponseEntity<CourseDTO> addStudents(@RequestBody Set<BaseUser> students, @PathVariable("courseId") Long id) {
        Course course = baseService.addStudents(students, id);
        return ResponseEntity.ok(baseMapper.toDTO(course));
    }
}
