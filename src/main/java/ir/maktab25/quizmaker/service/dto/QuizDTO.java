package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

import java.util.ArrayList;
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

    private boolean isActive;

    private UserDTO teacher;

    private List<UserDTO> students = new ArrayList<>();

    private List<QuestionWrapperDTO> questions = new ArrayList<>();

    @Getter(AccessLevel.NONE)
    private Long totalGrade;

    public Long getTotalGrade() {
        Long total = 0L;
        for (QuestionWrapperDTO ques : questions)
            if (ques != null && ques.getGrade() != null)
                total += ques.getGrade();
        return total;
    }
}
