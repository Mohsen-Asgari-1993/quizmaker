package ir.maktab25.quizmaker.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "descriptive_question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DescriptiveQuestion extends Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Answer answer;

}