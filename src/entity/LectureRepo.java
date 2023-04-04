package entity;

import utils.LectureUtils;

public class LectureRepo extends SuperRepo {
    private static Lecture[] lectures;

    public void createLectureMas() {
        lectures = new Lecture[Lecture.getCount()];
    }

    public static Lecture[] getLectures() {
        return lectures;
    }

    @Override
    public void getAll() {
        for (int i = 0; i < lectures.length; i++) {
            System.out.println(lectures[i]);
        }
    }

    @Override
    public void add() {
        LectureUtils lectureUtils = new LectureUtils();
        lectureUtils.createLecture();
    }

    @Override
    public void getByld() {                          //select id2
        if (lectures == null) {
            System.out.println(0);
            return;
        } else {
            for (int i = 0; i < lectures.length; i++) {
                Lecture lecture = lectures[i];
                if (lecture.getId() == 2 && TeacherRepo.getTeachers() != null) {
                    System.out.println(lecture);
                    System.out.println(TeacherRepo.getTeachers()[lecture.getPersonId() - 1]);
                }
            }
        }
    }


    @Override
    public void deleteByld() {
        Lecture[] lectures1 = new Lecture[lectures.length - 1];     //delete id2
        for (int i = 0; i < lectures1.length; i++) {
            if (i >= 1) {
                lectures1[i] = lectures[i + 1];
                continue;
            }
            lectures1[i] = lectures[i];
        }
        lectures = lectures1;
        for (int i = 0; i < lectures.length; i++) {
            System.out.println(lectures[i]);
        }
    }
}