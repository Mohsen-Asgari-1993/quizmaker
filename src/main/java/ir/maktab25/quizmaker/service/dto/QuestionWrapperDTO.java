package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionWrapperDTO extends BaseEntity<Long> {

    private Long id;

    private QuestionDTO question;

    private Long grade;
}
