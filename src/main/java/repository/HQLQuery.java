package repository;


import entity.Lecture;
import entity.Teacher;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;

public class HQLQuery {
    public static Boolean saveLecture(final Lecture lecture) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(lecture);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Lecture getLecture(final Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Query usersQuery = session.createQuery("from Lecture where id =:idLecture", Lecture.class);
            usersQuery.setParameter("idLecture", id);
            final Lecture singleResult = (Lecture) usersQuery.getSingleResult();
            return singleResult;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Boolean updateLecture(final Lecture lecture) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.update(lecture);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Boolean deleteLecture(final Lecture lecture) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.delete(lecture);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Boolean saveTeacher(final Teacher teacher) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            final Transaction transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            return true;
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }

    public static Teacher getTeacher(final Integer id) {
        try (final Session session = SessionCreator.getSessionFactory().openSession()) {
            return session.find(Teacher.class, id);
        } catch (final Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
