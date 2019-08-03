package ir.maktab25.quizmaker.service.dto;

import ir.maktab25.quizmaker.base.dto.BaseDTO;
import ir.maktab25.quizmaker.base.seurity.domian.enumeration.RoleName;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDTO extends BaseDTO<Long> {

    private Long id;

    private RoleName roleName;

}
