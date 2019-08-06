package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CourseDTO extends BaseDTO<Long> {

    private Long id;

    private String title;

    private Integer code;

    private String begin;

    private String end;

    private UserDTO teacher;

    private Set<UserDTO> students;
}
