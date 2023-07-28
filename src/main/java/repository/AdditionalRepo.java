package repository;

import entity.Additional;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class AdditionalRepo implements Repo {
    private static List<Additional> additionalArrayList = new ArrayList<>();
    private static Map<Integer, ArrayList<Additional>> additionalMap = new HashMap<>();

    public static List<Additional> getAdditionalArrayList() {
        return additionalArrayList;
    }

    public static Map<Integer, ArrayList<Additional>> getAdditionalMap() {
        return additionalMap;
    }
    public void addMap(Additional additional) {
        if (additionalMap.get(additional.getLectureId()) == null) {
            additionalMap.put(additional.getLectureId(), new ArrayList<Additional>());
        }
        additionalMap.get(additional.getLectureId()).add(additional);
    }
    @Override
    public int size() {
        return additionalArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (additionalArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return additionalArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        additionalArrayList.add((Additional) element);
    }

    @Override
    public void add(int index, Object element) {
        additionalArrayList.set(index, (Additional) element);
    }

    @Override
    public void remove(int index) {
        additionalArrayList.remove(additionalArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(additionalArrayList.toArray());
        Additional additional;
        while (simpleIterator.hasNext()) {
            additional = (Additional) simpleIterator.next();
            System.out.println(additional);
        }
        System.out.println("All additional materials");
        return;
    }

    @Override
    public boolean save(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save((Additional) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Object getById(Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Additional where id =:id", Additional.class);
            usersQuery.setParameter("id", id);
            final Additional singleResult = (Additional) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public boolean update(Object element) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update((Additional) element);
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
            session.delete((Additional) element);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
