package ir.maktab25.quizmaker.service;

import ir.maktab25.quizmaker.domain.Teacher;
import ir.maktab25.quizmaker.service.base.BasicUserService;

import java.util.List;

public interface TeacherService extends BasicUserService<Teacher, Long> {

    List<Teacher> findAllByCode(String code);
}
