package utils;

import entity.Course;
import entity.Lecture;
import entity.Student;
import entity.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import repository.CourseRepo;

@Component
public class CourseUtils {
    Student student;
    Teacher teacher;
    Lecture lecture;
    ApplicationContext context = new AnnotationConfigApplicationContext(CourseRepo.class);
    CourseRepo courseRepo = context.getBean(CourseRepo.class);

    public void createCourse() {

        Course course = new Course();
        course.setId(Course.getCount());
        course.setName("Course" + Course.getCount());

        courseRepo.add(course);
        courseRepo.save(course);

        for (int i = 0; i < courseRepo.size(); i++) {
            System.out.println("Index " + i + " " + courseRepo.get(i));
        }
    }
}