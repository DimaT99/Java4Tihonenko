package utils;

import entity.Course;
import entity.Lecture;

public class CourseUtils {
    Lecture lecture;
    //CourseRepo courseRepo = new CourseRepo();

    public void createCourse() {

        Course course = new Course();
        course.setId(Course.getCount());
        course.setName("Course" + Course.getCount());

        //courseRepo.add(course);

        System.out.println(course);

    }
}