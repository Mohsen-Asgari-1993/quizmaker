package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.domain.Answer;
import ir.maktab25.quizmaker.domain.enumeration.QuesitonType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    private String questionType;

    private Set<AnswerDTO> answers = new HashSet<>();

    private List<String> strings = new ArrayList<>();

    private List<Integer> integers = new ArrayList<>();
}
