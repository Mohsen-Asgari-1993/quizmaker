package ir.maktab25.quizmaker.controller.admin;

import ir.maktab25.quizmaker.base.seurity.rest.UserResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import ir.maktab25.quizmaker.service.mapper.UserDTOToStudentDTOMapper;
import ir.maktab25.quizmaker.service.mapper.UserDTOToTeacherDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/student")
public class AdminStudentController {

    @Autowired
    StudentResource studentResource;

    @Autowired
    TeacherResource teacherResource;

    @Autowired
    UserResource userResource;

    @Autowired
    UserDTOToStudentDTOMapper toStudentDTOMapper;

    @Autowired
    UserDTOToTeacherDTOMapper toTeacherDTOMapper;

    @GetMapping
    public String getStudents(Model model) {
        bindDataForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/enable/{id}")
    public String enableStudent(@PathVariable Long id, Model model) {
        studentResource.enableUser(id);
        bindDataForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id, Model model) {
        studentResource.deleteById(id);
        bindDataForAdminStudents(model);
        return "adminStudents";
    }

    @GetMapping("/show/{id}")
    public String showStudent(@PathVariable Long id, Model model) {
        bindDataForSingleStudent(model, id);
        return "adminSingleStudent";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model, UserDTO userDTO) {
        userDTO.setId(id);
        if (userDTO.getRole().equals("STUDENT")) {
            studentResource.update(toStudentDTOMapper.userDTOToStudentDTO(userDTO));
        } else {
            teacherResource.changeRole(toTeacherDTOMapper.userDTOToTeacherDTO(userDTO));
        }
        bindDataForAdminStudents(model);
        return "adminStudents";
    }

    private void bindDataForAdminStudents(Model model) {
        List<StudentDTO> enables = studentResource.findAllEnables().getBody();
        List<StudentDTO> disables = studentResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
    }

    private void bindDataForSingleStudent(Model model, Long id) {
        model.addAttribute("student", userResource.getById(id).getBody());
    }

}
