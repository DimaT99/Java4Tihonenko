package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Student;
import repository.StudentRepo;

public class StudentUtils {
    StudentRepo studentRepo = new StudentRepo();

    public void createStudent() {
        Student student = new Student();
        student.setId(Student.getCount());
        student.setName("Student" + Student.getCount());
        Person person = new Person();
        person.setId(Person.getCount());
        person.setCourseId(Course.getCount());
        person.setEnumRole(EnumRole.STUDENT);
        person.setFirstName(person.validFirstName("First name") + Person.getCount());
        person.setLastName(person.validLastName("Last name") + Person.getCount());
        person.setPhone(person.validPhone("000 000 00 00"));
        person.setEmail(person.validEmail("email33@gmail.com"));
        student.setPerson(person);

            studentRepo.add(student);

        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }
}