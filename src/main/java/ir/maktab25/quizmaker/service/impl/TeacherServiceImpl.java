package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.repository.TeacherRepository;
import ir.maktab25.quizmaker.service.TeacherService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl extends BasicUserServiceImpl<Teacher, Long, TeacherRepository> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<Teacher> findAllByCode(String code) {
        return baseRepository.findAllByCode(code);
    }
}
