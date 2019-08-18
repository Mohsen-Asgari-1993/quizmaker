package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QuizDTO extends BaseDTO<Long> {

    private Long id;

    private String title;

    private String description;

    private Long timer;

    private UserDTO teacher;

    private List<UserDTO> students;

    private List<QuestionDTO> questions;

}
