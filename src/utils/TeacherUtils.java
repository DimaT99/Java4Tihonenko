package utils;

import entity.Teacher;
import entity.TeacherRepo;

public class TeacherUtils {
    void createTeacher() {
        Teacher teacher = new Teacher();
        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.createTeacherMas();
        TeacherRepo.teachers[0] = teacher;
        System.out.println(TeacherRepo.teachers[0]);
    }
}
