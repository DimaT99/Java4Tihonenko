package utils;

import entity.Course;
import entity.EnumRole;
import entity.Person;
import entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.PersonRepo;
import repository.TeacherRepo;
@Component
public class TeacherUtils {
    ApplicationContext context = new AnnotationConfigApplicationContext(TeacherRepo.class);
    TeacherRepo teacherRepo = context.getBean(TeacherRepo.class);
    ApplicationContext context2 = new AnnotationConfigApplicationContext(PersonRepo.class);
    PersonRepo personRepo = context2.getBean(PersonRepo.class);

    public void createTeacher() {

        Teacher teacher = new Teacher();
        teacher.setId(Teacher.getCount());
        teacher.setName("Teacher" + Teacher.getCount());
        Person person = new Person();
        person.setId(Person.getCount());
        person.setCourseId(Course.getCount());
        person.setEnumRole(EnumRole.TEACHER);
        person.setFirstName(person.validFirstName("First name") + Person.getCount());
        if (Person.getCount() % 2 == 0) {
            person.setLastName(person.validLastName("Last name") + Person.getCount());
        } else {
            person.setLastName(person.validLastName("Pythonworker") + Person.getCount());
        }
        person.setPhone(person.validPhone("null"));   //"000 000 00 00"
        person.setEmail(person.validEmail(emailDuplicate("email" + Person.getCount() + "@gmail.com")));
        teacher.setPerson(person);
        personRepo.add(person);
        personRepo.save(person);

        teacherRepo.add(teacher);
        teacherRepo.save(teacher);

        for (int i = 0; i < teacherRepo.size(); i++) {
            System.out.println("Index " + i + " " + teacherRepo.get(i));
        }
    }

    public void teacherListLastname() {
        TeacherRepo.getTeacherArrayList().stream().filter(teach -> teach.getPerson().getLastName().substring(0, 1).compareTo("N") < 0)
                .forEach(teacher -> System.out.println(teacher.getPerson().getLastName()));
    }

    String emailDuplicate(String email) {
        if (TeacherRepo.getTeacherArrayList().stream()
                .noneMatch(e -> e.getPerson().getEmail().equals(email))) {
            return email;
        }
        System.out.println("This email already exists");
        return "This email already exists";
    }
}
