package ir.maktab25.quizmaker.controller.admin;

import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/student")
public class AdminStudentController {

    @Autowired
    StudentResource studentResource;

    @GetMapping("")
    public String getStudents(Model model) {
        bindDateForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/enable/{id}")
    public String enableStudent(@PathVariable Long id, Model model) {
        studentResource.enableUser(id);
        bindDateForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/delete/{id}")
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
