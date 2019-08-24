package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnswerDTO extends BaseDTO<Long> {

    private Long id;

    private String content;

    private String bool;

    private Boolean isTrue;

    private Boolean isChosen;

}
