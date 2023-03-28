package utils;

import entity.*;

import java.util.Scanner;

public class ConsoleUtils {
    public void ScannerWithSwitch() {

        CourseUtils courseUtils1 = new CourseUtils();
        courseUtils1.createCourse();

        LectionUtils lectionUtils1 = new LectionUtils();
        lectionUtils1.createLection();

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
                System.out.println("5. Output of created objects");
                System.out.println("6. Exit");

                category = scanner.nextInt();
            } while (category < 1 || category > 6);

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
                    LectionUtils lectionUtils = new LectionUtils();
                    lectionUtils.createLection();
                    break;
                case 5:
                    System.out.println("Output of created objects");
                    outputObject();
                    break;
                case 6:
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
                if (CourseRepo.courses == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < CourseRepo.courses.length; i++) {
                        System.out.println(CourseRepo.courses[i].getId());
                    }
                }
                break;
            case 2:
                System.out.println("Created objects Teacher");
                if (TeacherRepo.teachers == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < TeacherRepo.teachers.length; i++) {
                        //System.out.println(TeacherRepo.teachers[i].getId());
                    }
                }
                break;
            case 3:
                System.out.println("Created objects Student");
                if (StudentRepo.students == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < StudentRepo.students.length; i++) {
                        //System.out.println(StudentRepo.students[i].getId());
                    }
                }
                break;
            case 4:
                System.out.println("Created objects Lecture");
                if (LectionRepo.lections == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < LectionRepo.lections.length; i++) {
                        System.out.println(LectionRepo.lections[i].getId());
                    }
                }
                break;
            case 5:
                System.out.println("Created objects Homework");
                if (HomeworkRepo.homeworks == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < HomeworkRepo.homeworks.length; i++) {
                       //System.out.println(HomeworkRepo.homeworks[i].getId());
                    }
                }
                break;
            case 6:
                System.out.println("Created objects Additional");
                if (AdditionalRepo.additionals == null) {
                    System.out.println(0);
                } else {
                for (int i = 0; i < AdditionalRepo.additionals.length; i++) {
                    //System.out.println(AdditionalRepo.additionals[i].getId());
                }}
                break;
            default:
                System.out.println("Incorrect symbol");
        }
    }
}

