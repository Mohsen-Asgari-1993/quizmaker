package ir.maktab25.quizmaker.base.seurity.rest;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import ir.maktab25.quizmaker.base.seurity.serivce.UserService;
import ir.maktab25.quizmaker.rest.base.BasicUserResource;
import ir.maktab25.quizmaker.service.dto.BaseUserDTO;
import ir.maktab25.quizmaker.service.mapper.BaseUserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")
public class UserResource extends BasicUserResource<User, BaseUserDTO, Long, UserService, BaseUserMapper> {

    public UserResource(UserService baseService, BaseUserMapper baseMapper) {
        super(baseService, baseMapper);
    }

}
