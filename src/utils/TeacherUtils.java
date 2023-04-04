package utils;

import entity.*;

import java.util.Arrays;

public class TeacherUtils {

    void createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(Teacher.getCount());
        teacher.setName("Teacher" + Teacher.getCount());
        Person person = new Person();
        person.setId(Person.getCount());
        person.setCourseId(Course.getCount());
        person.setEnumRole(EnumRole.TEACHER);
        teacher.person = person;

        if (Teacher.getCount() == 1) {
            TeacherRepo teacherRepo = new TeacherRepo();
            teacherRepo.createTeacherMas();
            TeacherRepo.getTeachers()[0] = teacher;
        } else {
            Teacher[] teachers = Arrays.copyOf(TeacherRepo.getTeachers(), TeacherRepo.getTeachers().length + Teacher.getCount());
            for (int i = TeacherRepo.getTeachers().length; i < teachers.length; i++) {
                teachers[i] = teacher;
                TeacherRepo teacherRepo = new TeacherRepo();
                teacherRepo.createTeacherMas();
                for (int a = 0; a < TeacherRepo.getTeachers().length; a++) {
                    TeacherRepo.getTeachers()[a] = teachers[a];
                }
            }
        }
        for (int i = 0; i < TeacherRepo.getTeachers().length; i++) {
            System.out.println("Index " + i + " " + TeacherRepo.getTeachers()[i]);
        }
    }
}
