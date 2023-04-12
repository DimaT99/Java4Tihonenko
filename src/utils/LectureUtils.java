package utils;

import entity.*;

import java.util.Arrays;

public class LectureUtils {
    Course course;
    Homework homework;
    Additional additional;
    Repo<Lecture> lectureRepo = new Repo<>();
    private Lecture lecture;
    private Lecture[] lectures;

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
            lecture = new Lecture();
            lecture.setCourseId(Course.getCount());
            lecture.setId(Lecture.getCount());
            lecture.setPersonId(Teacher.getCount());
            lecture.setName("Lecture" + Lecture.getCount());
            lecture.setDescription("Description" + Lecture.getCount());
            if (lectureRepo.isEmpty()) {
                lectures = new Lecture[Lecture.getCount()];
                lectureRepo.addAll(lectures);
                lectureRepo.add(0, lecture);
            } else {

                //lectureRepo.add(lecture);        //void add(E element)

                Lecture[] lectures1 = Arrays.copyOf(lectureRepo.getEntityArray(), (lectureRepo.size() * 3) / 2 + 1);
                lectureRepo.addAll(lectures1);
                lectureRepo.add(Lecture.getCount() - 1, lecture);
            }
            lectureRepo.remove(0);
        }
        for (int i = 0; i < lectureRepo.size(); i++) {
            System.out.println("Index " + i + " " + lectureRepo.get(i));
        }
    }
}



