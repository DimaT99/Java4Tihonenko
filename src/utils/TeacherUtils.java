package utils;

import entity.*;
import repository.TeacherRepo;

import java.util.Arrays;
import java.util.regex.Pattern;

public class TeacherUtils {
    TeacherRepo teacherRepo = new TeacherRepo();

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

        if (teacherRepo.isEmpty()) {
            teacherRepo.createTeacherMas();
            teacherRepo.add(Teacher.getCount() - 1, teacher);
        } else {
            Teacher[] teachers1 = Arrays.copyOf(TeacherRepo.getTeachers(), (teacherRepo.size() * 3) / 2 + 1);
            teacherRepo.addAll(teachers1);
            teacherRepo.add(Teacher.getCount() - 1, teacher);
        }
        for (int i = 0; i < teacherRepo.size(); i++) {
            System.out.println("Index " + i + " " + teacherRepo.get(i));
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