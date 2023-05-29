package serialization;

import entity.*;
import repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {
    public static List<Object> allCourseInfo = new ArrayList<>();

    static void addCourseBackup() {
        for (Course course : CourseRepo.getCourseArrayList()) {
            if (course.getId() == 1) {
                allCourseInfo.add(course);
            }
        }
        for (Lecture lecture : LectureRepo.getLectureArrayList()) {
            if (lecture.getCourseId() == 1) {
                allCourseInfo.add(lecture);
                lecture.getId();
            }
            for (Homework homework : HomeworkRepo.getHomeworkArrayList()) {
                if (homework.getLectureId() == lecture.getId()) {
                    allCourseInfo.add(homework);
                }
            }
            for (Additional additional : AdditionalRepo.getAdditionalArrayList()) {
                if (additional.getLectureId() == lecture.getId()) {
                    allCourseInfo.add(additional);
                }
            }
        }
        for (Teacher teacher : TeacherRepo.getTeacherArrayList()) {
            if (teacher.getPerson().getCourseId() == 1) {
                allCourseInfo.add(teacher);
            }
        }
        for (Student student : StudentRepo.getStudentArrayList()) {
            if (student.getPerson().getCourseId() == 1) {
                allCourseInfo.add(student);
            }
        }
    }

    public static void serialization(final String path) {
        addCourseBackup();
        File file = new File(path);
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(allCourseInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deserialization(final String path) {
        final File file = new File(path);
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            List<Object> courseBackup = (List<Object>) inputStream.readObject();
            System.out.println('\n' + "Deserialization data:");
            for (Object info : courseBackup) {
                System.out.println(info);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
