package utils;

import entity.Course;

import java.util.Scanner;

public class ConsoleUtils {
    public void ScannerWithSwitch() {

        Scanner scanner = new Scanner(System.in);
        int category;
        boolean stop = true;
        while (stop) {
            do {
                System.out.println("Select category:");
                System.out.println("1. Course");
                System.out.println("2. Teacher");
                System.out.println("3. Student");
                System.out.println("4. Lection");
                System.out.println("5. Exit");

                category = scanner.nextInt();
            } while (category < 1 || category > 5);

            switch (category) {
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
                    LectionUtils lectionUtils = new LectionUtils();
                    lectionUtils.createLectionConsole();
                    break;
                case 5:
                    stop = false;
                    break;
                default:
                    System.out.println("No such category exist");
            }
        }
    }
}
