package utils;

import entity.*;
import repository.HomeworkRepo;
import repository.LectureRepo;

import java.util.Arrays;

public class LectureUtils {
    Homework homework;
    Additional additional;
    LectureRepo lectureRepo = new LectureRepo();

    public void createLecture() {

        for (int j = 0; j < 100; j++) {
            if (j == 3) {
                break;
            }
            Lecture lecture = new Lecture();
            lecture.setCourseId(Course.getCount());
            lecture.setId(Lecture.getCount());
            lecture.setPersonId(Teacher.getCount());
            lecture.setName("Lecture" + Lecture.getCount());
            lecture.setDescription("Description" + Lecture.getCount());
            HomeworkUtils homeworkUtils = new HomeworkUtils();
            homeworkUtils.createHomework();
            lecture.setHomeworks(HomeworkRepo.getHomeworks());
            if (lectureRepo.isEmpty()) {
                lectureRepo.createLectureMas();
                lectureRepo.add(Teacher.getCount() - 1, lecture);
            } else {
                Lecture[] lectures1 = Arrays.copyOf(LectureRepo.getLectures(), (lectureRepo.size() * 3) / 2 + 1);
                lectureRepo.addAll(lectures1);
                lectureRepo.add(Lecture.getCount() - 1, lecture);
            }
        }
        lectureRepo.remove(0);
        for (int i = 0; i < lectureRepo.size(); i++) {
            System.out.println("Index " + i + " " + lectureRepo.get(i));
        }
    }
}



