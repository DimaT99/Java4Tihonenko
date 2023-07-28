package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.PersonRepo;
import repository.StudentRepo;

import java.util.Optional;

@Component
public class StudentUtils {
    ApplicationContext context = new AnnotationConfigApplicationContext(StudentRepo.class);
    StudentRepo studentRepo = context.getBean(StudentRepo.class);
    ApplicationContext context2 = new AnnotationConfigApplicationContext(PersonRepo.class);
    PersonRepo personRepo = context2.getBean(PersonRepo.class);

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
        person.setEmail(person.validEmail(emailDuplicate("email" + Person.getCount() + "@gmail.com")));
        student.setPerson(person);
        personRepo.add(person);
        personRepo.save(person);

        studentRepo.add(student);
        studentRepo.save(student);

        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }

    public void addStudent() {              //optional wrapper lesson 29
        Student student;
        student = (Student) Optional.ofNullable(null).orElseGet(() -> new Student(Student.getCount() + 1,
                "Excellent", new Person(emailDuplicate("email33@gmail.com3"))));
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