package utils;

import entity.*;

import java.util.Arrays;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lection lection;

    public Course course;

    public CourseUtils(Course course) {
        this.course = course;
        System.out.println(course);
    }

    public CourseUtils() {

    }

    public void createCourse() {

        Course course = new Course();
        course.setId(Course.count);
        if (Course.count == 1) {
            CourseRepo courseRepo = new CourseRepo();
            courseRepo.createCourseMas();
            CourseRepo.courses[0] = course;
        } else {
            Course[] courses = Arrays.copyOf(CourseRepo.courses, Course.count);
            for (int i = CourseRepo.courses.length; i < courses.length; i++) {
                courses[i] = course;
                CourseRepo.courses = courses;
            }
            for (int i = 0; i < CourseRepo.courses.length; i++) {
                System.out.println("Index i = " + courses[i]);
            }
        }
        System.out.println("Index 0 = " + CourseRepo.courses[0]);

    }
}

