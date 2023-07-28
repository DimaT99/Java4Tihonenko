package utils;

import entity.Homework;
import entity.Lecture;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.HomeworkRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
@Component
public class HomeworkUtils {
    ApplicationContext context = new AnnotationConfigApplicationContext(HomeworkRepo.class);
    HomeworkRepo homeworkRepo = context.getBean(HomeworkRepo.class);

    public void createHomework() {
        Homework homework = new Homework();
        homework.setId(Homework.getCount());
        homework.setLectureId(Lecture.getCount());
        homework.setTask("Task" + Homework.getCount());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, HH:mm", Locale.ENGLISH);
        homework.setDeadline(LocalDate.now().plusDays(1).atTime(12, 00).format(formatter));

            homeworkRepo.add(homework);
            homeworkRepo.addMap(homework);
            homeworkRepo.save(homework);

        for (int i = 0; i < homeworkRepo.size(); i++) {
            //System.out.println("Index " + i + " " + homeworkRepo.get(i));
        }
    }
}
