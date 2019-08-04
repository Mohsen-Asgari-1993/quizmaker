package ir.maktab25.quizmaker.domain;

import ir.maktab25.quizmaker.base.seurity.domian.User;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
