package repository;

import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherRepo implements Repo {
    private static List<Teacher> teacherArrayList = new ArrayList<>();

    //private static Teacher[] teachers;

    public static List<Teacher> getTeacherArrayList() {
        return teacherArrayList;
    }

    public int size() {
        return teacherArrayList.size();
    }

    public Teacher get(int index) {
        return teacherArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        teacherArrayList.add((Teacher) element);
    }

    @Override
    public void add(int index, Object element) {
        teacherArrayList.set(index, (Teacher) element);
    }

    @Override
    public void remove(int index) {
        teacherArrayList.remove(teacherArrayList.get(index));
    }

    public boolean isEmpty() {
        if (teacherArrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void remove(Teacher teacher) {
        teacherArrayList.remove(teacher);
    }

    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(teacherArrayList.toArray());
        Teacher teacher;
        while (simpleIterator.hasNext()) {
            teacher = (Teacher) simpleIterator.next();
            System.out.println(teacher);
        }
        System.out.println("All teacher");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Teacher) element);
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
            final Teacher singleResult = (Teacher) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Teacher) element);
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
            session.delete((Teacher) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
