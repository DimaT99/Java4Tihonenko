package utils;

import entity.Homework;
import entity.HomeworkRepo;

public class HomeworkUtils {
    public void createHomework() {
        Homework homework = new Homework();
        HomeworkRepo homeworkRepo = new HomeworkRepo();
        homeworkRepo.createHomeworkMas();
        HomeworkRepo.homeworks[0] = homework;
        System.out.println(HomeworkRepo.homeworks[0]);
    }
}
