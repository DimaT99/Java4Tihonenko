package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Teacher;
import repository.TeacherRepo;

import java.util.Arrays;

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
        person.setFirstName(person.validFirstName("First name") + Person.getCount());
        person.setLastName(person.validLastName("Last name") + Person.getCount());
        person.setPhone(person.validPhone("null"));   //"000 000 00 00"
        person.setEmail(person.validEmail(null)); //"email33@gmail.com"
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
}