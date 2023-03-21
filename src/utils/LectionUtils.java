package utils;

import entity.Additional;
import entity.Course;
import entity.Homework;
import entity.Lection;

import java.util.Scanner;

public class LectionUtils {
    Course course;
    Homework homework;
    Additional additional;


    private Lection lection;

    public LectionUtils(Lection lection) {
        this.lection = lection;
        System.out.println(lection);
    }

    public LectionUtils() {

    }

    public void createLectionConsole() {
        final Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the type of chose, please use only numbers from 1 to 2");
        System.out.println("Please input 1 if you want to crete lection");
        System.out.println("Please input 2 if you want to crete lection and stop program");

        int create = scanner.nextInt();


        switch (create) {
            case 1:
                Course course1 = new Course(888);
                Lection lection7 = new Lection(course1.getId(), 7, "Lection 7");
                System.out.println("Course id = " + lection7.courseId);
                final Scanner scanner1 = new Scanner(System.in);
                System.out.println("Please enter if you want to crete lection and stop program");
                scanner1.nextLine();

            case 2:
                Course course2 = new Course(999);
                Lection lection8 = new Lection(course2.getId(), 8, "Lection 8");
                System.out.println("Course id = " + lection8.courseId);
                Lection.sayCount();
                break;
            default:
                System.out.println("Incorrect symbol");
        }

    }


}
