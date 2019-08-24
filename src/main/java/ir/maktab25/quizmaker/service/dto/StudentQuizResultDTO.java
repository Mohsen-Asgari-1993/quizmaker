package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.domain.QuestionWrapper;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentQuizResultDTO extends BaseDTO<Long> {

    private Long id;

    private Set<QuestionWrapper> questions = new HashSet<>();

    private Long studentId;

    private Long quizId;

    @Getter(AccessLevel.NONE)
    private Long totalGrade;

    public Long getTotalGrade() {
        Long grade = 0L;
        for (QuestionWrapper ques : questions)
            if (ques != null && ques.getGrade() != null)
                grade += ques.getGrade();
        return grade;
    }
}
