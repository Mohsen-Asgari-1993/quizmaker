package ir.maktab25.quizmaker.controller.admin;

import ir.maktab25.quizmaker.base.seurity.rest.UserResource;
import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
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
@RequestMapping("/admin/teacher")
public class AdminTeacherController {

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
    public String getTeachers(Model model) {
        bindDataForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/enable/{id}")
    public String enableTeacher(@PathVariable Long id, Model model) {
        teacherResource.enableUser(id);
        bindDataForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/delete/{id}")
    public String deleteTeacher(@PathVariable Long id, Model model) {
        teacherResource.deleteById(id);
        bindDataForAdminTeachers(model);
        return "adminTeachers";
    }

    @GetMapping("/show/{id}")
    public String showTeacher(@PathVariable Long id, Model model) {
        bindDataForSingleTeacher(model, id);
        return "adminSingleTeacher";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable Long id, Model model, UserDTO userDTO) {
        userDTO.setId(id);
        if (userDTO.getRole().equals("TEACHER")) {
            teacherResource.update(toTeacherDTOMapper.userDTOToTeacherDTO(userDTO));
        } else {
            studentResource.changeRole(toStudentDTOMapper.userDTOToStudentDTO(userDTO));
        }
        bindDataForAdminTeachers(model);
        return "adminStudents";
    }

    private void bindDataForAdminTeachers(Model model) {
        List<TeacherDTO> enables = teacherResource.findAllEnables().getBody();
        List<TeacherDTO> disables = teacherResource.findAllDisable().getBody();
        model.addAttribute("enables", enables);
        model.addAttribute("disables", disables);
    }

    private void bindDataForSingleTeacher(Model model, Long id) {
        model.addAttribute("teacher", userResource.getById(id).getBody());
    }

}
