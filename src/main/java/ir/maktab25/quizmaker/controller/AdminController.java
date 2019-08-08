package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CourseResource courseResource;

    @Autowired
    TeacherResource teacherResource;

    @Autowired
    StudentResource studentResource;

    @GetMapping("/course")
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

    @GetMapping("/course/show/{id}")
    public String showCourse(@PathVariable Long id, Model model) {
        model.addAttribute("teachers", teacherResource.findAllEnables().getBody());
        model.addAttribute("course", courseResource.getById(id).getBody());
        return "adminSingleCourse";
    }

    @PostMapping("/course/update/{id}")
    public String updateCourse(@PathVariable Long id, Model model, CourseDTO courseDTO) {
        courseResource.update(courseDTO);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }

    @GetMapping("/course/addTeacher/{courseId}/{teacherId}")
    public String addTeacherToCourse(@PathVariable Long courseId, @PathVariable Long teacherId, Model model) {
        courseResource.addTeacher(teacherId, courseId);
        model.addAttribute("teachers", teacherResource.findAllEnables().getBody());
        model.addAttribute("course", courseResource.getById(courseId).getBody());
        return "adminSingleCourse";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable Long id, Model model) {
        courseResource.deleteById(id);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }


    @GetMapping("/teacher")
    public String getTeachers(Model model) {
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/teacher/enable/{id}")
    public String enableTeacher(@PathVariable Long id, Model model) {
        teacherResource.enableUser(id);
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/teacher/delete/{id}")
    public String deleteTeacher(@PathVariable Long id, Model model) {
        teacherResource.deleteById(id);
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    private void bindDateForAdminTeachers(Model model) {
        List<TeacherDTO> enables = teacherResource.findAllEnables().getBody();
        List<TeacherDTO> disables = teacherResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
    }

    @GetMapping("/student")
    public String getStudents(Model model) {
        bindDateForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/Students/enable/{id}")
    public String enableStudent(@PathVariable Long id, Model model) {
        studentResource.enableUser(id);
        bindDateForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/Students/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentResource.deleteById(id);
        bindDateForAdminStudents(model);
        return "adminStudents";
    }

    private void bindDateForAdminStudents(Model model) {
        List<StudentDTO> enables = studentResource.findAllEnables().getBody();
        List<StudentDTO> disables = studentResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
    }


}
