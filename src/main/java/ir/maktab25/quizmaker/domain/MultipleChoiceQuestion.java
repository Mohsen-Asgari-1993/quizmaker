package ir.maktab25.quizmaker.domain;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "multiple_choice_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MultipleChoiceQuestion extends Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private List<Answer> answers;
}
