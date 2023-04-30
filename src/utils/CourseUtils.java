package utils;

import entity.Course;
import entity.Lecture;
import entity.Student;
import entity.Teacher;
import repository.CourseRepo;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lecture lecture;
    CourseRepo courseRepo = new CourseRepo();

    public void createCourse() {

        Course course = new Course();
        course.setId(Course.getCount());
        course.setName("Course" + Course.getCount());

            courseRepo.add(course);

        for (int i = 0; i < courseRepo.size(); i++) {
            System.out.println("Index " + i + " " + courseRepo.get(i));
        }
    }
}