package ir.maktab25.quizmaker.controller;

import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/templates/login.html")
    public String login(BaseUserDTO baseUserDTO){
        return "login";
    }
}
