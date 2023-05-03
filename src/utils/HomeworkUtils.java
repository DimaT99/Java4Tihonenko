package utils;

import entity.Homework;
import entity.Lecture;
import repository.HomeworkRepo;

public class HomeworkUtils {
    HomeworkRepo homeworkRepo = new HomeworkRepo();

    public void createHomework() {
        Homework homework = new Homework();
        homework.setId(Homework.getCount());
        homework.setLectureId(Lecture.getCount());
        homework.setTask("Task" + Homework.getCount());

            homeworkRepo.add(homework);

        for (int i = 0; i < homeworkRepo.size(); i++) {
            //System.out.println("Index " + i + " " + homeworkRepo.get(i));
        }
    }
}
