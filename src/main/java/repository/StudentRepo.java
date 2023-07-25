package repository;

import entity.Student;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Component
public class StudentRepo implements Repo {
    private static List<Student> studentArrayList = new ArrayList<>();
    //private static Student[] students;

    public static List<Student> getStudentArrayList() {
        return studentArrayList;
    }

    @Override
    public int size() {
        return studentArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (studentArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return studentArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        studentArrayList.add((Student) element);
    }

    @Override
    public void add(int index, Object element) {
        studentArrayList.set(index, (Student) element);
    }

    @Override
    public void remove(int index) {
        studentArrayList.remove(studentArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(studentArrayList.toArray());
        Student student;
        while (simpleIterator.hasNext()) {
            student = (Student) simpleIterator.next();
            System.out.println(student);
        }
        System.out.println("All student");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Student) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object getById(Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Student where id =:id", Student.class);
            usersQuery.setParameter("id", id);
            final Student singleResult = (Student) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Student) element);
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
            session.delete((Student) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
