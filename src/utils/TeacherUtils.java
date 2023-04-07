package utils;

import entity.*;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TeacherUtils {

    public void createTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(Teacher.getCount());
        teacher.setName("Teacher" + Teacher.getCount());
        Person person = new Person();
        person.setId(Person.getCount());
        person.setCourseId(Course.getCount());
        person.setEnumRole(EnumRole.TEACHER);
        person.setFirstName(validFirstName("First name") + Person.getCount());
        person.setLastName(validLastName("Last name") + Person.getCount());
        person.setPhone(validPhone("000 000 00 00"));
        person.setEmail(validEmail("email33@gmail.com"));
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

    public String validEmail(String email) {
        if (Pattern.matches("\\w+@\\w+\\.\\w+", email)) {
            System.out.println("email ok");
            return email;
        } else {
            System.out.println("Invalid email, please enter a valid email");
        }
        return "Wrong email";
    }

    public String validPhone(String phone) {
        if (Pattern.matches("\\d{10}||\\d{3} \\d{3} \\d{2} \\d{2}||\\d{3} \\d{7}", phone)) {
            System.out.println("phone ok");
            return phone;
        } else {
            System.out.println("Invalid phone, please enter a valid phone");
        }
        return "Wrong phone";
    }

    public String validFirstName(String firstName) {
        if (Pattern.matches("\\D+", firstName)) {
            System.out.println("First name ok");
            return firstName;
        } else {
            System.out.println("Invalid First name, please enter a valid First name");
        }
        return "Wrong First name";
    }

    public String validLastName(String lastName) {
        if (Pattern.matches("\\D+", lastName)) {
            System.out.println("Last name ok");
            return lastName;
        } else {
            System.out.println("Invalid Last name, please enter a valid Last name");
        }
        return "Wrong Last name";
    }
}