package utils;

import entity.*;

import java.util.Arrays;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lecture lecture;
    Repo<Course> courseRepo = new Repo<>();
    public Course course;

    public CourseUtils(Course course) {
        this.course = course;
        System.out.println(course);
    }

    public CourseUtils() {

    }

    public void createCourse() {

        Course course = new Course(1, "Course");
        course.setId(Course.getCount());
        course.setName("Course");
        if (courseRepo.isEmpty()) {
            Course[] courses = new Course[Course.getCount()];
            courses[0] = course;
            courseRepo.addAll(courses);
        } else {
            Course[] courses = Arrays.copyOf(courseRepo.getEntityArray(), (courseRepo.size() * 3) / 2 + 1);
            for (int i = courseRepo.size(); i < courses.length; i++) {
                courses[i] = course;
                Course[] courses1 = new Course[Course.getCount()];
                for (int a = 0; a < courseRepo.size(); a++) {
                    courses1[a] = courses[a];
                }
                courseRepo.addAll(courses1);
            }
        }
        for (int i = 0; i < courseRepo.size(); i++) {
            System.out.println("Index " + i + " " + courseRepo.get(i));
        }
    }
}