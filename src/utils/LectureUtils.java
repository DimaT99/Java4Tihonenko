package utils;

import entity.*;
import exception.EntityNotFoundException;
import repository.HomeworkRepo;
import repository.LectureRepo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LectureUtils {
    Homework homework;
    Additional additional;
    LectureRepo lectureRepo = new LectureRepo();

    public void createLecture() {

        for (int j = 0; j < 100; j++) {
            if (j == 5) {
                break;
            }
            Lecture lecture = new Lecture();
            lecture.setCourseId(Course.getCount());
            lecture.setId(Lecture.getCount());
            lecture.setPersonId(Teacher.getCount());
            lecture.setName("Lecture" + Lecture.getCount());
            lecture.setDescription("Description" + Lecture.getCount());
            lecture.setDate(LocalDate.now().plusDays(Lecture.getCount()));
            HomeworkUtils homeworkUtils = new HomeworkUtils();
            homeworkUtils.createHomework();
            AdditionalUtils additionalUtils = new AdditionalUtils();
            additionalUtils.createAdditional();
            lecture.setHomeworkList(HomeworkRepo.getHomeworkArrayList());

                lectureRepo.add(lecture);
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
        LectureUtils lectureUtils = new LectureUtils();
        lectureUtils.createLecture();
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
}



