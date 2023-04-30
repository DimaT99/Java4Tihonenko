package utils;

import entity.*;
import exception.EntityNotFoundException;
import repository.HomeworkRepo;
import repository.LectureRepo;

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
            lecture.setHomeworkList(HomeworkRepo.getHomeworkArrayList());

                lectureRepo.add(lecture);
        }
        //lectureRepo.remove(0);
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

    public void getByld(int idLection) {
        try {
            if (lectureRepo.get(idLection) != null && idLection < lectureRepo.size()) {
                System.out.println(lectureRepo.get(idLection));
                //System.out.println(TeacherRepo.getTeachers()[idLection - 1]);
            } else {
                throw new EntityNotFoundException();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteByld() {
        Lecture[] lectures1 = new Lecture[lectureRepo.size() - 1];     //delete id2
        for (int i = 0; i < lectures1.length; i++) {
            if (i >= 1) {
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



