package ir.maktab25.quizmaker.controller.admin;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/course")
public class AdminCourseController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    TeacherResource teacherResource;

    @Autowired
    StudentResource studentResource;

    @GetMapping
    public String getCourses(Model model, CourseDTO courseDTO) {
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", courseDTO);
        return "adminCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(Model model, CourseDTO courseDTO) {
        courseResource.create(courseDTO);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }

    @GetMapping("/show/{id}")
    public String showCourse(@PathVariable Long id, Model model) {
        bindDataForSingleCourse(model, id);
        return "adminSingleCourse";
    }

    @PostMapping("/update/{id}")
    public String updateCourse(@PathVariable Long id, Model model, CourseDTO courseDTO) {
        courseDTO.setId(id);
        courseResource.update(courseDTO);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }

    @GetMapping("/addTeacher/{courseId}/{teacherId}")
    public String addTeacherToCourse(@PathVariable Long courseId, @PathVariable Long teacherId, Model model) {
        courseResource.addTeacher(teacherId, courseId);
        bindDataForSingleCourse(model, courseId);

        return "adminSingleCourse";
    }

    @GetMapping("/deleteStudent/{courseId}/{studentId}")
    public String deleteStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        courseResource.deleteStudent(courseId, studentId);
        bindDataForSingleCourse(model, courseId);
        return "adminSingleCourse";
    }

    @GetMapping("/addStudent/{courseId}/{studentId}")
    public String addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId, Model model) {
        courseResource.addStudent(courseId, studentId);
        bindDataForSingleCourse(model, courseId);
        return "adminSingleCourse";
    }

    @PostMapping("/addStudents/{courseId}")
    public String addStudentsToCourse(@RequestBody List<Long> studentsId, @PathVariable Long courseId, Model model) {
        courseResource.addStudents(studentsId, courseId);
        bindDataForSingleCourse(model, courseId);
        return "adminSingleCourse";
    }

    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id, Model model) {
        courseResource.deleteById(id);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }

    private void bindDataForSingleCourse(Model model, Long courseId) {
        model.addAttribute("teachers", teacherResource.findAllEnables().getBody());
        model.addAttribute("course", courseResource.getById(courseId).getBody());
        model.addAttribute("students", studentResource.findAllEnables().getBody());
    }


}
