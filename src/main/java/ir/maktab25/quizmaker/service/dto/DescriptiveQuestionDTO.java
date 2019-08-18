package ir.maktab25.quizmaker.service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DescriptiveQuestionDTO extends QuestionDTO {

    private Long id;

    private AnswerDTO answer;

}
