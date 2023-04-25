package utils;

import entity.*;
import repository.CourseRepo;
import repository.LectureRepo;

import java.util.Arrays;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lecture lecture;
    CourseRepo courseRepo = new CourseRepo();

    public void createCourse() {

        Course course = new Course();
        course.setId(Course.getCount());
        course.setName("Course" + Course.getCount());
        if (courseRepo.isEmpty()) {
            courseRepo.createCourseMas();
            courseRepo.add(Course.getCount() - 1, course);
        } else {
            Course[] courses1 = Arrays.copyOf(CourseRepo.getCourses(), (courseRepo.size() * 3) / 2 + 1);
            courseRepo.addAll(courses1);
            courseRepo.add(Course.getCount() - 1, course);
        }
        for (int i = 0; i < courseRepo.size(); i++) {
            System.out.println("Index " + i + " " + courseRepo.get(i));
        }
    }
}