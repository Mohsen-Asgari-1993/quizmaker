package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student_quiz_result")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentQuizResult extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Set<QuestionWrapper> questions = new HashSet<>();

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "quiz_id")
    private Long quizId;

}
