package utils;

import entity.Course;
import entity.Lection;
import entity.Student;
import entity.Teacher;

import java.util.Scanner;

public class CourseUtils {
    Student student;
    Teacher teacher;
    Lection lection;

    private Course course;

    public CourseUtils(Course course) {
        this.course = course;
        System.out.println(course);
    }

    public CourseUtils() {

    }

    public void ScannerWithSwitch() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select category:");
        System.out.println("1. Course");
        System.out.println("2. Teacher");
        System.out.println("3. Student");
        System.out.println("4. Lection");

        int category = scanner.nextInt();

        switch (category)
        {
            case 1:
                Course course;
                System.out.println("Category Course");
                break;
            case 2:
                System.out.println("Category Teacher");
                break;
            case 3:
                System.out.println("Category Student");
                break;
            case 4:
                System.out.println("Category Lection");
                break;
            default:
                System.out.println("No such category exist");
        }
    }
}
