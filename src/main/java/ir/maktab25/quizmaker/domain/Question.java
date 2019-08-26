package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "question")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "header")
    private String header;

    @Column(name = "grade")
    private Long grade;

    @OneToOne
    private User teacher;
}
