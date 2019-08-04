package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO extends BaseDTO<Long> {

    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String phoneNumber;

    private String password;

    private Boolean isActive;

    private String role;

    private Set<RoleDTO> roles = new HashSet<>();
}
