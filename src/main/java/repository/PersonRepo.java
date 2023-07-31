package repository;

import entity.Person;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.persistence.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonRepo implements Repo {
    static List<Person> personArrayList = new ArrayList<>();

    @Override
    public int size() {
        return personArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (personArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return personArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        personArrayList.add((Person) element);
    }

    @Override
    public void add(int index, Object element) {
        personArrayList.set(index, (Person) element);
    }

    @Override
    public void remove(int index) {
        personArrayList.remove(personArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(personArrayList.toArray());
        Person person;
        while (simpleIterator.hasNext()) {
            person = (Person) simpleIterator.next();
            System.out.println(person);
        }
        System.out.println("All persons");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Person) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object getById(Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Teacher where id =:id", Teacher.class);
            usersQuery.setParameter("id", id);
            final Person singleResult = (Person) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Person) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean delete(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.delete((Person) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
