package utils;

import entity.Homework;
import entity.Lecture;
import repository.HomeworkRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HomeworkUtils {
    HomeworkRepo homeworkRepo = new HomeworkRepo();

    public void createHomework() {
        Homework homework = new Homework();
        homework.setId(Homework.getCount());
        homework.setLectureId(Lecture.getCount());
        homework.setTask("Task" + Homework.getCount());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, HH:mm", Locale.ENGLISH);
        homework.setDeadline(LocalDate.now().plusDays(1).atTime(12, 00).format(formatter));

            homeworkRepo.add(homework);
            homeworkRepo.addMap(homework);

        for (int i = 0; i < homeworkRepo.size(); i++) {
            //System.out.println("Index " + i + " " + homeworkRepo.get(i));
        }
    }
}
