package lesson61.service;

import entity.EnumRole;
import lesson61.entity.Person;
import lesson61.repo.PersonRepo61;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PersonService {
    private final PersonRepo61 personRepo61;

    @Autowired
    public PersonService(final PersonRepo61 personRepo61) {
        this.personRepo61 = personRepo61;
    }

    public void savePerson(final lesson61.entity.Person person) {
        personRepo61.save(person);
    }

    public List<lesson61.entity.Person> findAll() {
        return personRepo61.findAll();
    }

    public Optional<lesson61.entity.Person> getPerson(final Integer id) {
        return personRepo61.findById(id);
    }

    public List<lesson61.entity.Person> getPersonList() {
        return personRepo61.findAllByCourseId(1);
    }

    public void updatePerson(final PersonRepo61 person) {
        personRepo61.updatePerson((Person) person);
    }
    public void createPersonsBeforeStart() {
        final Random random = new Random();
        final int count = random.nextInt(10, 20);

        for (int i = 0; i < count; i++) {
            final Person person = new Person();
            person.setCourseId(random.nextInt(1, 10));
            person.setFirstName("Sponge%d".formatted(i));
            person.setLastName("Bob%d".formatted(i));

            if (i % 2 == 0) {
                person.setEnumRole(EnumRole.TEACHER);
            } else {
                person.setEnumRole(EnumRole.STUDENT);
            }
            personRepo61.save(person);
        }
    }
}
