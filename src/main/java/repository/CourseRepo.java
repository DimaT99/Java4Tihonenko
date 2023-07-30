package repository;

import entity.Course;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseRepo implements Repo {
    private static List<Course> courseArrayList = new ArrayList<>();

    public static List<Course> getCourseArrayList() {
        return courseArrayList;
    }

    @Override
    public int size() {
        return courseArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (courseArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return courseArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        courseArrayList.add((Course) element);
    }

    @Override
    public void add(int index, Object element) {
        courseArrayList.set(index, (Course) element);
    }

    @Override
    public void remove(int index) {
        courseArrayList.remove(courseArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(courseArrayList.toArray());
        Course course;
        while (simpleIterator.hasNext()) {
            course = (Course) simpleIterator.next();
            System.out.println(course);
        }
        System.out.println("All course");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Course) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object getById(Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Course where id =:id", Course.class);
            usersQuery.setParameter("id", id);
            final Course singleResult = (Course) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Course) element);
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
            session.delete((Course) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
