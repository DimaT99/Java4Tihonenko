package utils;

import entity.Homework;
import entity.Lecture;
import repository.HomeworkRepo;

import java.util.Arrays;

public class HomeworkUtils {
    HomeworkRepo homeworkRepo = new HomeworkRepo();

    public void createHomework() {
        Homework homework = new Homework();
        homework.setId(Homework.getCount());
        homework.setLectureId(Lecture.getCount());
        homework.setTask("Task" + Homework.getCount());
        if (homeworkRepo.isEmpty()) {
            homeworkRepo.createHomeworkMas();
            homeworkRepo.add(Homework.getCount() - 1, homework);
        } else {
            Homework[] homeworks1 = Arrays.copyOf(HomeworkRepo.getHomeworks(), (homeworkRepo.size() * 3) / 2 + 1);
            homeworkRepo.addAll(homeworks1);
            homeworkRepo.add(Homework.getCount() - 1, homework);
        }
        for (int i = 0; i < homeworkRepo.size(); i++) {
            //System.out.println("Index " + i + " " + homeworkRepo.get(i));
        }
    }
}
