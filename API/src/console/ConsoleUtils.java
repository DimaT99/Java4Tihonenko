package console;

import utils.CourseUtils;
import utils.LectureUtils;
import utils.TeacherUtils;

import java.util.Scanner;

public class ConsoleUtils {

    public void ScannerWithSwitch() {

        Scanner scanner = new Scanner(System.in);
        int category = 0;
        boolean stop = true;
        while (stop) {
            do {
                System.out.println("Select category:");
                System.out.println("1. Create Course");
                System.out.println("2. Create Teacher");
                System.out.println("3. Create Lecture");
                System.out.println("4. Exit");

                try {
                    category = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("Incorrect symbol. Choose the right category");
                    ScannerWithSwitch();
                    return;
                }
            } while (category < 1 || category > 4);
            switch (category) {
                case 1:
                    System.out.println("Category Course");
                    CourseUtils courseUtils = new CourseUtils();
                    courseUtils.createCourse();
                    break;
                case 2:
                    System.out.println("Category Teacher");
                    TeacherUtils teacherUtils = new TeacherUtils();
                    teacherUtils.createTeacher();
                    break;
                case 3:
                    System.out.println("Category Lecture");
                    LectureUtils lectureUtils = new LectureUtils();
                    lectureUtils.createLecture();
                    break;
                case 4:
                    stop = false;
                    break;
                default:
                    System.out.println("No such category exist");
            }
        }
    }
}