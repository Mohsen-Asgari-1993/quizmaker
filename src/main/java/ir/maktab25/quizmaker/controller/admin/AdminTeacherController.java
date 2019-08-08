package ir.maktab25.quizmaker.controller.admin;

import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/teacher")
public class AdminTeacherController {

    @Autowired
    TeacherResource teacherResource;

    @GetMapping
    public String getTeachers(Model model) {
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/enable/{id}")
    public String enableTeacher(@PathVariable Long id, Model model) {
        teacherResource.enableUser(id);
        bindDateForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/delete/{id}")
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

}
