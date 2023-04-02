package utils;

import entity.Homework;
import entity.HomeworkRepo;

public class HomeworkUtils {
    public void createHomework() {
        Homework homework = new Homework(1, "Homework");
        homework.setId(1);
        HomeworkRepo homeworkRepo = new HomeworkRepo();
        homeworkRepo.createHomeworkMas();
        HomeworkRepo.getHomeworks()[0] = homework;
        System.out.println(HomeworkRepo.getHomeworks()[0]);
    }
}
