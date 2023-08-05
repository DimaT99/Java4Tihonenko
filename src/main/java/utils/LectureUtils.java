package utils;

import entity.*;
import exception.EntityNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.AdditionalRepo;
import repository.LectureRepo;
import repository.SessionCreator;
import workLog.LogUtils;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Component
public class LectureUtils {
    Homework homework;
    Additional additional;
    ApplicationContext context = new AnnotationConfigApplicationContext(AdditionalUtils.class);
    AdditionalUtils additionalUtils = context.getBean(AdditionalUtils.class);
    ApplicationContext context2 = new AnnotationConfigApplicationContext(LectureRepo.class);
    LectureRepo lectureRepo = context2.getBean(LectureRepo.class);
    ApplicationContext context3 = new AnnotationConfigApplicationContext(HomeworkUtils.class);
    HomeworkUtils homeworkUtils = context3.getBean(HomeworkUtils.class);
    ApplicationContext context4 = new AnnotationConfigApplicationContext(LogUtils.class);
    LogUtils logUtils = context4.getBean(LogUtils.class);

    public LectureUtils() {
    }
    public LectureUtils(LectureRepo lectureRepo) {
        this.lectureRepo = lectureRepo;
    }

    public void createLecture() {
        LogUtils.className = Lecture.class;
        for (int j = 0; j < 100; j++) {
            if (j == 5) {
                break;
            }
            Lecture lecture = new Lecture();
            System.out.println(Lecture.getCount());
            lecture.setCourseId(Course.getCount());
            lecture.setId(Lecture.getCount());
            lecture.setPersonId(Teacher.getCount());
            lecture.setName("Lecture%d".formatted(Lecture.getCount()));
            lecture.setDescription("Description" + Lecture.getCount());
            lecture.setDate(LocalDate.now().plusDays(Lecture.getCount())); //for the task filterLectures (lesson 27)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, EEEE HH:mm:ss", Locale.ENGLISH);
            lecture.setLectureDate(formatter.format(LocalDateTime.now()));
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            lecture.setCreationDate(formatter1.format(LocalDateTime.now()));
            homeworkUtils.createHomework();
            additionalUtils.createAdditional();
            //lecture.setHomeworkList(HomeworkRepo.getHomeworkArrayList());
            logUtils.info("Lecture created", lecture.getCreationDate());
            lectureRepo.add(lecture);
            lectureRepo.save(lecture);
        }
        for (int i = 0; i < lectureRepo.size(); i++) {
            System.out.println("Index " + i + " " + lectureRepo.get(i));
        }
    }
    public void getAll() {
        for (int i = 0; i < lectureRepo.size(); i++) {
            System.out.println(lectureRepo.get(i));
        }
    }

    public void add() {
        createLecture();
    }

    public void getByld(int idLecture) {
        try {
            if (lectureRepo.get(idLecture) != null && idLecture < lectureRepo.size()) {
                System.out.println(lectureRepo.get(idLecture - 1));
            } else {
                throw new EntityNotFoundException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteByld(int idLecture) {
        Lecture[] lectures1 = new Lecture[lectureRepo.size() - 1];
        for (int i = 0; i < lectures1.length; i++) {
            if (i >= idLecture - 1) {
                lectures1[i] = (Lecture) lectureRepo.get(i + 1);
                continue;
            }
            lectures1[i] = (Lecture) lectureRepo.get(i);
        }
        for (int i = 0; i < lectures1.length; i++) {
            System.out.println(lectures1[i]);
        }
    }

    public void lectureSearch() {
        int maxAdditional = LectureRepo.getLectureArrayList().stream()
                .map(lecture -> AdditionalRepo.getAdditionalMap().get(lecture.getId()).size())
                .max(Integer::compareTo)
                .orElseThrow();
        String minDate = LectureRepo.getLectureArrayList().stream()
                .filter(lecture -> AdditionalRepo.getAdditionalMap().get(lecture.getId()).size() == maxAdditional)
                .map(Lecture::getLectureDate)
                .min(String::compareTo)
                .orElseThrow();
        LectureRepo.getLectureArrayList().stream()
                .filter(lecture -> lecture.getLectureDate() == minDate)
                .forEach(System.out::println);

        System.out.println("Amount of additional materials = " + maxAdditional);
    }

    public boolean checkLecturePresence(Lecture lecture) throws Exception {
        Lecture lectureToFind = lectureRepo.getLectureByLectureName(lecture.getName());

        return lectureToFind != null;
    }

    public List<Lecture> getLectures() {
        final SessionFactory sessionFactory = SessionCreator.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Lecture> criteriaQuery = criteriaBuilder.createQuery(Lecture.class);

            Root<Lecture> root = criteriaQuery.from(Lecture.class);
            criteriaQuery.select(root);
            final org.hibernate.query.Query<Lecture> query = session.createQuery(criteriaQuery);

            return query.getResultList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Lecture getLecture(final String name) {
        final SessionFactory sessionFactory = SessionCreator.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            final CriteriaQuery<Lecture> criteriaQuery = criteriaBuilder.createQuery(Lecture.class);

            Root<Lecture> root = criteriaQuery.from(Lecture.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
            final org.hibernate.query.Query<Lecture> query = session.createQuery(criteriaQuery);
            return query.getSingleResult();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int updateLecture(final Lecture lecture) {
        final SessionFactory sessionFactory = SessionCreator.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            final Transaction transaction = session.beginTransaction();

            final CriteriaUpdate<Lecture> criteriaUpdate = criteriaBuilder.createCriteriaUpdate(Lecture.class);
            Root<Lecture> root = criteriaUpdate.from(Lecture.class);
            criteriaUpdate.set("name", lecture.getName());
            criteriaUpdate.where(criteriaBuilder.equal(root.get("id"), lecture.getId()));

            final int i = session.createQuery(criteriaUpdate).executeUpdate();

            transaction.commit();

            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteLecture(final Lecture lecture) {
        final SessionFactory sessionFactory = SessionCreator.getSessionFactory();

        try (Session session = sessionFactory.openSession()) {
            final CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

            final Transaction transaction = session.beginTransaction();

            final CriteriaDelete<Lecture> criteriaDelete = criteriaBuilder.createCriteriaDelete(Lecture.class);
            Root<Lecture> root = criteriaDelete.from(Lecture.class);
            criteriaDelete.where(criteriaBuilder.equal(root.get("id"), lecture.getId()));

            final int i = session.createQuery(criteriaDelete).executeUpdate();

            transaction.commit();

            return i;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



