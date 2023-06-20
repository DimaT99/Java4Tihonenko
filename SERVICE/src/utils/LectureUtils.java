package utils;

import entity.Course;
import entity.Lecture;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LectureUtils {
    //LectureRepo lectureRepo = new LectureRepo();

    public void createLecture() {

            Lecture lecture = new Lecture();
            lecture.setCourseId(Course.getCount());
            lecture.setId(Lecture.getCount());
            lecture.setName("Lecture" + Lecture.getCount());
            lecture.setDescription("Description" + Lecture.getCount());
            lecture.setDate(LocalDate.now().plusDays(Lecture.getCount())); //for the task filterLectures (lesson 27)
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, EEEE HH:mm:ss", Locale.ENGLISH);
            lecture.setLectureDate(formatter.format(LocalDateTime.now()));
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
            lecture.setCreationDate(formatter1.format(LocalDateTime.now()));
            //lectureRepo.add(lecture);
            System.out.println(lecture);
    }

    public void add() {
        LectureUtils lectureUtils = new LectureUtils();
        lectureUtils.createLecture();
    }
}



