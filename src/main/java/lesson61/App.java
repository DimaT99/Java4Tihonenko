package lesson61;

import lesson61.entity.Person;
import lesson61.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        final ApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        PersonService personService = ctx.getBean(PersonService.class);
        personService.createPersonsBeforeStart();

        final List<Person> all = personService.findAll();
        all.forEach(System.out::println);

        final Integer id = 5;

        final Person person = personService.getPerson(id).orElse(null);
        System.out.printf("my person by id %d %s%n", id, person);

        final Person person1 = personService.getPerson(50).orElse(null);
        System.out.printf("my person by id with out value %s".formatted(person1));

        person.setCourseId(100);
        person.setFirstName("Star");
        person.setLastName("Patric");

        /*mouseService.updateMouse(mouse);*/

        personService.savePerson(person);

    }
}
