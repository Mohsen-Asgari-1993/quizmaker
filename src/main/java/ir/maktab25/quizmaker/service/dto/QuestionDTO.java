package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionDTO extends BaseDTO<Long> {

    private Long id;

    private String title;

    private String header;

    private Long grade;

    private UserDTO teacher;
}
