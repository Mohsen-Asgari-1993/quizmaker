package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.service.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login.html")
    public String login(UserDTO userDTO){
        return "login";
    }
}
