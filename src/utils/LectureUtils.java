package utils;

import entity.*;

import java.util.Arrays;

public class LectureUtils {
    Course course;
    Homework homework;
    Additional additional;


    private Lecture lecture;

    public LectureUtils(Lecture lecture) {
        this.lecture = lecture;
        System.out.println(lecture);
    }

    public LectureUtils() {

    }

    public void createLecture() {

        for (int j = 0; j < 100; j++) {
            if (j == 3) {
                break;
            }
            Lecture lecture = new Lecture();
            lecture.setCourseId(CourseRepo.getCourses()[Course.getCount() - 1].getId());
            lecture.setId(Lecture.getCount());
            lecture.setPersonId(Teacher.getCount());
            lecture.setName("Lecture" + Lecture.getCount());
            if (Lecture.getCount() == 1) {
                LectureRepo lectureRepo = new LectureRepo();
                lectureRepo.createLectureMas();
                LectureRepo.getLectures()[0] = lecture;
            } else {
                Lecture[] lectures = Arrays.copyOf(LectureRepo.getLectures(), (LectureRepo.getLectures().length * 3) / 2 + 1);
                for (int i = LectureRepo.getLectures().length; i < lectures.length; i++) {
                    lectures[i] = lecture;
                    LectureRepo lectureRepo = new LectureRepo();
                    lectureRepo.createLectureMas();
                    for (int a = 0; a < LectureRepo.getLectures().length; a++) {
                        LectureRepo.getLectures()[a] = lectures[a];
                    }
                }
            }
        }
        for (int i = 0; i < LectureRepo.getLectures().length; i++) {
            System.out.println("Index " + i + " " + LectureRepo.getLectures()[i]);
        }
    }
}

