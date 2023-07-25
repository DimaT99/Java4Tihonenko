package repository;

import entity.Homework;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HomeworkRepo implements Repo {
    private static List<Homework> homeworkArrayList = new ArrayList<>();
    private static Map<Integer, List<Homework>> homeworkMap = new HashMap<>();

    public static Map<Integer, List<Homework>> getHomeworkMap() {
        return homeworkMap;
    }

    public static void setHomeworkMap(Map<Integer, List<Homework>> homeworkMap) {
        HomeworkRepo.homeworkMap = homeworkMap;
    }

    public static List<Homework> getHomeworkArrayList() {
        return homeworkArrayList;
    }

    public void addMap(Homework homework) {
        if (homeworkMap.get(homework.getLectureId()) == null) {
            homeworkMap.put(homework.getLectureId(), new ArrayList<Homework>());
        }
        homeworkMap.get(homework.getLectureId()).add(homework);
    }

    @Override
    public int size() {
        return homeworkArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (homeworkArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return homeworkArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        homeworkArrayList.add((Homework) element);
    }

    @Override
    public void add(int index, Object element) {
        homeworkArrayList.set(index, (Homework) element);
    }

    @Override
    public void remove(int index) {
        homeworkArrayList.remove(homeworkArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(homeworkArrayList.toArray());
        Homework homework;
        while (simpleIterator.hasNext()) {
            homework = (Homework) simpleIterator.next();
            System.out.println(homework);
        }
        System.out.println("All homework");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Homework) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object getById(Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Homework where id =:id", Homework.class);
            usersQuery.setParameter("id", id);
            final Homework singleResult = (Homework) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Homework) element);
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
            session.delete((Homework) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
