package ir.maktab25.quizmaker.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import ir.maktab25.quizmaker.rest.CourseResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.CourseDTO;
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

    @GetMapping("/course")
    public String getCourses(Model model, CourseDTO courseDTO) {
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", courseDTO);
        return "adminCourse";
    }

    @PostMapping("/addCourse")
    public String addCourse(Model model, CourseDTO courseDTO){
        courseResource.create(courseDTO);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", new CourseDTO());
        return "adminCourse";
    }

    @GetMapping("/course/show/{id}")
    public String showCourse(@PathVariable Long id, Model model){
        model.addAttribute("course", courseResource.getById(id).getBody());
        model.addAttribute("dto", new CourseDTO());
        return "adminSingleCourse";
    }

    @GetMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable Long id, Model model, CourseDTO courseDTO){
        courseResource.deleteById(id);
        List<CourseDTO> body = courseResource.getAllNotPageable().getBody();
        model.addAttribute("courses", body);
        model.addAttribute("dto", courseDTO);
        return "adminCourse";
    }



    @GetMapping("/teacher")
    public String getTeachers(Model model) {
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/teacher/enable/{id}")
    public String enable(@PathVariable Long id, Model model){
        teacherResource.enableUser(id);
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/teacher/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        teacherResource.deleteById(id);
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    private void bindDateForAdminTeachers(Model model){
        List<TeacherDTO> enables = teacherResource.findAllEnables().getBody();
        List<TeacherDTO> disables = teacherResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
    }
}
