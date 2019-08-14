package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import lombok.*;

import java.util.Set;


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

    private User teacher;

    private Set<User> students;
}
