package ir.maktab25.quizmaker.service.dto;

import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TeacherDTO extends UserDTO {

    private Long id;

    private String code;
}
