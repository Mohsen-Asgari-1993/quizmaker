package ir.maktab25.quizmaker.service.impl;

import ir.maktab25.quizmaker.domain.Student;
import ir.maktab25.quizmaker.repository.StudentRepository;
import ir.maktab25.quizmaker.service.StudentService;
import ir.maktab25.quizmaker.service.impl.base.BasicUserServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl extends BasicUserServiceImpl<Student, Long, StudentRepository> implements StudentService {

    public StudentServiceImpl(StudentRepository baseRepository) {
        super(baseRepository);
    }
}
