package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.rest.StudentResource;
import ir.maktab25.quizmaker.rest.TeacherResource;
import ir.maktab25.quizmaker.service.dto.StudentDTO;
import ir.maktab25.quizmaker.service.dto.TeacherDTO;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    StudentResource studentResource;

    @Autowired
    TeacherResource teacherResource;

    @GetMapping("/login.html")
    public String login(UserDTO userDTO, Model model) {
        model.addAttribute("user", userDTO);
        return "login";
    }

    @PostMapping("/register")
    public String register(UserDTO userDTO, Model model) {
        try {
            if (userDTO.getRole().equals("TEACHER"))
                saveTeacher(userDTO);
            else if (userDTO.getRole().equals("STUDENT"))
                saveStudent(userDTO);
            else
                throw new Exception("fail");
            return "successRegister";
        } catch (Exception e) {
            return "failRegister";
        }

    }

    private void saveTeacher(UserDTO userDTO) {
        TeacherDTO teacherDTO = new TeacherDTO();
        setProperties(userDTO, teacherDTO);
        teacherResource.create(teacherDTO);
    }

    private void saveStudent(UserDTO userDTO) {
        StudentDTO studentDTO = new StudentDTO();
        setProperties(userDTO, studentDTO);
        studentResource.create(studentDTO);
    }

    private void setProperties(UserDTO source, UserDTO target) {
        target.setEmail(source.getEmail());
        target.setFirstName(source.getFirstName());
        target.setLastName(source.getLastName());
        target.setUserName(source.getUserName());
        target.setPassword(source.getPassword());
    }
}
