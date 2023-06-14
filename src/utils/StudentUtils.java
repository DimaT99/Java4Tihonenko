package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Student;
import repository.StudentRepo;

import java.util.Optional;

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
        person.setEmail(person.validEmail(emailDuplicate("email33@gmail.com" + Person.getCount())));
        student.setPerson(person);

        studentRepo.add(student);

        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }

    public void addStudent() {              //optional wrapper lesson 29
        Student student;
        student = (Student) Optional.ofNullable(null).orElseGet(() -> new Student(Student.getCount() + 1, "Excellent", new Person(emailDuplicate("email33@gmail.com3"))));
        //System.out.println(student.getName());
        studentRepo.add(student);
    }
    String emailDuplicate(String email) {
        if (StudentRepo.getStudentArrayList().stream()
                .noneMatch(e -> e.getPerson().getEmail().equals(email))) {
            return email;
        }
        System.out.println("This email already exists");
        return "This email already exists";
    }
}