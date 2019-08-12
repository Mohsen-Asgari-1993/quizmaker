package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.domain.BaseEntity;
import ir.maktab25.quizmaker.base.seurity.domian.User;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "code", unique = true)
    private Integer code;

    @Column(name = "begin")
    private String begin;

    @Column(name = "end")
    private String end;

    @OneToOne
    private User teacher;

    @OneToMany
    private Set<User> students;

    @OneToMany
    private Set<Quiz> quizzes;
}
