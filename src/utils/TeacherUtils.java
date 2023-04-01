package utils;

import entity.Teacher;
import entity.TeacherRepo;

public class TeacherUtils {
    void createTeacher() {
        Teacher teacher = new Teacher(1, "Teacher");
        teacher.setId(1);
        teacher.setName("Teacher");
        TeacherRepo teacherRepo = new TeacherRepo();
        teacherRepo.createTeacherMas();
        TeacherRepo.getTeachers()[0] = teacher;
        System.out.println(TeacherRepo.getTeachers()[0]);
    }
}
