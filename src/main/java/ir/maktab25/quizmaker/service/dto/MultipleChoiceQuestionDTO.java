package ir.maktab25.quizmaker.service.dto;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MultipleChoiceQuestionDTO extends QuestionDTO {

    private Long id;

    private List<AnswerDTO> answers;
}
