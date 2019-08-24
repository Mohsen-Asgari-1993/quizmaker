package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "question_wrapper")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QuestionWrapper extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Question question;

    @Column(name = "grade")
    private Long grade;
}
