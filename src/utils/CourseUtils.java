package utils;

import entity.Course;
import entity.Lection;
import entity.Student;
import entity.Teacher;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lection lection;

    private Course course;

    public CourseUtils(Course course) {
        this.course = course;
        System.out.println(course);
    }

}
