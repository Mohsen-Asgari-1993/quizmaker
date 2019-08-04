package ir.maktab25.quizmaker.base.seurity.rest;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import ir.maktab25.quizmaker.rest.base.BasicUserResource;
import ir.maktab25.quizmaker.service.dto.UserDTO;
import ir.maktab25.quizmaker.service.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserResource extends BasicUserResource<User, UserDTO, Long, UserService, UserMapper> {

    public UserResource(UserService baseService, UserMapper baseMapper) {
        super(baseService, baseMapper);
    }

}
