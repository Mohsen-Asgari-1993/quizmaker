package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionBankDTO extends BaseDTO<Long> {

    private List<Long> longList = new ArrayList<>();
}
