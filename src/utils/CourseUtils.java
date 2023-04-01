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

        Course course = new Course(1, "Course");
        course.setId(Course.count);
        course.setName("Course");
        if (Course.count == 1) {
            CourseRepo courseRepo = new CourseRepo();
            courseRepo.createCourseMas();
            CourseRepo.getCourses()[0] = course;
        } else {
            Course[] courses = Arrays.copyOf(CourseRepo.getCourses(), Course.count);
            for (int i = CourseRepo.getCourses().length; i < courses.length; i++) {
                courses[i] = course;
                CourseRepo courseRepo = new CourseRepo();
                courseRepo.createCourseMas();
                for (int j = 0; j < courses.length; j++) {
                    CourseRepo.getCourses()[j] = courses[j];
                }
            }
        }
        for (int i = 0; i < CourseRepo.getCourses().length; i++) {
            System.out.println("Index" + i + " " + CourseRepo.getCourses()[i]);
        }
    }
}


