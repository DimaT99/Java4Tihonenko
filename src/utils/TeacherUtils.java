package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Teacher;
import repository.TeacherRepo;

public class TeacherUtils {
    private TeacherRepo teacherRepo = new TeacherRepo();

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
        person.setEmail(person.validEmail("email33@gmail.com"));
        teacher.setPerson(person);

        teacherRepo.add(teacher);

        for (int i = 0; i < teacherRepo.size(); i++) {
            System.out.println("Index " + i + " " + teacherRepo.get(i));
        }
    }
}
