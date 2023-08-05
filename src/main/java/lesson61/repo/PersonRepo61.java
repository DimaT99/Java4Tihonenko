package lesson61.repo;

import lesson61.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface PersonRepo61 extends JpaRepository<Person, Integer> {
    List<Person> findAllByCourseId(int courseId);

    @Modifying
    @Transactional
    @Query("UPDATE Person p SET p.firstName = :#{#updatedPerson.firstName}, p.lastName = :#{#updatedPerson.lastName}, p.enumRole = :#{#updatedPerson.enumRole}, p.courseId = :#{#updatedPerson.courseId} WHERE p.id = :#{#updatedPerson.id}")
    void updatePerson(Person updatedPerson);
}
