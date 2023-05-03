package utils;

import repository.*;

import java.util.Scanner;

public class ConsoleUtils {
    public void ScannerWithSwitch() {

        CourseUtils courseUtils1 = new CourseUtils();
        courseUtils1.createCourse();

        TeacherUtils teacherUtils1 = new TeacherUtils();
        teacherUtils1.createTeacher();

        LectureUtils lectureUtils1 = new LectureUtils();
        lectureUtils1.createLecture();

        Scanner scanner = new Scanner(System.in);
        int category;
        boolean stop = true;
        while (stop) {
            do {
                System.out.println("Select category:");
                System.out.println("1. Course");
                System.out.println("2. Teacher");
                System.out.println("3. Student");
                System.out.println("4. Lecture");
                System.out.println("5. Additional materials");
                System.out.println("6. Output of created objects");
                System.out.println("7. Lecture menu");
                System.out.println("8. Exit");

                try {
                    category = scanner.nextInt();
                } catch (Exception e) {
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        System.out.println(stackTraceElement);
                    }
                    System.out.println("Incorrect symbol. Choose the right category");
                    scanner = new Scanner(System.in);
                    category = scanner.nextInt();
                }
            } while (category < 1 || category > 8);
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
                    System.out.println("Category Student");
                    StudentUtils studentUtils = new StudentUtils();
                    studentUtils.createStudent();
                    break;
                case 4:
                    System.out.println("Category Lecture");
                    LectureUtils lectureUtils = new LectureUtils();
                    lectureUtils.createLecture();
                    break;
                case 5:
                    System.out.println("Category Additional materials");
                    AdditionalUtils additionalUtils = new AdditionalUtils();
                    additionalUtils.createAdditional();
                    break;
                case 6:
                    System.out.println("Output of created objects");
                    outputObject();
                    break;
                case 7:
                    System.out.println("Lecture menu");
                    lectionJobs();
                    break;
                case 8:
                    stop = false;
                    break;
                default:
                    System.out.println("No such category exist");
            }
        }
    }

    public void outputObject() {

        int category;
        final Scanner scanner1 = new Scanner(System.in);
        System.out.println("Select the category of created objects, please use only numbers from 1 to 6");
        System.out.println("1. Created objects Course");
        System.out.println("2. Created objects Teacher");
        System.out.println("3. Created objects Student");
        System.out.println("4. Created objects Lecture");
        System.out.println("5. Created objects Homework");
        System.out.println("6. Created objects Additional");
        category = scanner1.nextInt();

        switch (category) {
            case 1:
                System.out.println("Created objects Course");
                CourseRepo courseRepo = new CourseRepo();
                courseRepo.findAll();
                break;
            case 2:
                System.out.println("Created objects Teacher");
                TeacherRepo teacherRepo = new TeacherRepo();
                teacherRepo.findAll();
                break;
            case 3:
                System.out.println("Created objects Student");
                StudentRepo studentRepo = new StudentRepo();
                studentRepo.findAll();
                break;
            case 4:
                System.out.println("Created objects Lecture");
                LectureRepo lectureRepo = new LectureRepo();
                lectureRepo.findAll();
                break;
            case 5:
                System.out.println("Created objects Homework");
                HomeworkRepo homeworkRepo = new HomeworkRepo();
                homeworkRepo.findAll();
                break;
            case 6:
                System.out.println("Created objects Additional");
                AdditionalRepo additionalRepo = new AdditionalRepo();
                additionalRepo.findAll();
                break;
            default:
                System.out.println("Incorrect symbol");
        }

    }

    public void lectionJobs() {

        int category;
        LectureUtils lectureUtils = new LectureUtils();
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Select the category, please use only numbers from 1 to 4");
        System.out.println("1. Return an array");
        System.out.println("2. Add a new lecture");
        System.out.println("3. Open the selected lecture");
        System.out.println("4. Delete the selected lecture");
        try {
            category = scanner2.nextInt();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Incorrect symbol. Choose the right category");
            scanner2 = new Scanner(System.in);
            category = scanner2.nextInt();
        }
        switch (category) {
            case 1:
                System.out.println("Return an array");
                lectureUtils.getAll();

                break;
            case 2:
                System.out.println("Add a new lecture");
                lectureUtils.add();

                break;
            case 3:
                System.out.println("Open the selected lecture");
                lectureUtils.getByld(1);
                break;
            case 4:
                System.out.println("Delete the selected lecture");   //delete id2
                lectureUtils.deleteByld();
                break;

            default:
                System.out.println("Incorrect symbol");
        }
    }
}
