package ir.maktab25.quizmaker.service.dto;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BaseUserDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String userName;

    private String email;

    private String phoneNumber;

    private String password;

    private Boolean isActive;

    private Set<RoleDTO> roles = new HashSet<>();
}
