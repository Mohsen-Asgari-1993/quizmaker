package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "answer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    @Lob
    private String title;
}
