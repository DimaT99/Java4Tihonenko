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
                System.out.println("5. Output of created objects");
                System.out.println("6. Overridden methods");
                System.out.println("7. Exit");

                category = scanner.nextInt();
            } while (category < 1 || category > 7);
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
                    System.out.println("Output of created objects");
                    outputObject();
                    break;
                case 6:
                    System.out.println("Overridden methods");
                    //overrideMethods();
                    break;
                case 7:
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
                if (courseRepo.isEmpty()) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < courseRepo.size(); i++) {
                        System.out.println(courseRepo.get(i));
                    }
                }
                break;
            case 2:
                System.out.println("Created objects Teacher");
                TeacherRepo teacherRepo = new TeacherRepo();
                if (teacherRepo.isEmpty()) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < teacherRepo.size(); i++) {
                        System.out.println(teacherRepo.get(i));
                    }
                }
                break;
            case 3:
                System.out.println("Created objects Student");
                StudentRepo studentRepo = new StudentRepo();
                if (studentRepo.isEmpty()) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < studentRepo.size(); i++) {
                        System.out.println(studentRepo.get(i));
                    }
                }
                break;
            case 4:
                System.out.println("Created objects Lecture");
                LectureRepo lectureRepo = new LectureRepo();
                if (lectureRepo.isEmpty()) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < lectureRepo.size(); i++) {
                        System.out.println(lectureRepo.get(i));
                    }
                }
                break;
            case 5:
                System.out.println("Created objects Homework");
                if (HomeworkRepo.getHomeworks() == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < HomeworkRepo.getHomeworks().length; i++) {
                        System.out.println(HomeworkRepo.getHomeworks()[i].getId());
                    }
                }
                break;
            case 6:
                System.out.println("Created objects Additional");
                if (AdditionalRepo.getAdditionals() == null) {
                    System.out.println(0);
                } else {
                    for (int i = 0; i < AdditionalRepo.getAdditionals().length; i++) {
                        System.out.println(AdditionalRepo.getAdditionals()[i].getId());
                    }
                }
                break;
            default:
                System.out.println("Incorrect symbol");
        }
    }

    /*public void overrideMethods() {

        int category;
        final Scanner scanner2 = new Scanner(System.in);
        System.out.println("Select the category, please use only numbers from 1 to 4");
        System.out.println("1. Return an array");
        System.out.println("2. Add a new lecture");
        System.out.println("3. Open the selected lecture");
        System.out.println("4. Delete the selected lecture");

        category = scanner2.nextInt();

        switch (category) {
            case 1:
                System.out.println("Return an array");
                LectureRepo lectureRepo = new LectureRepo();
                lectureRepo.getAll();

                break;
            case 2:
                System.out.println("Add a new lecture");
                LectureRepo lectureRepo1 = new LectureRepo();
                lectureRepo1.add();

                break;
            case 3:
                System.out.println("Open the selected lecture");   //select id2
                LectureRepo lectureRepo2 = new LectureRepo();
                lectureRepo2.getByld();
                break;
            case 4:
                System.out.println("Delete the selected lecture");   //delete id2
                LectureRepo lectureRepo3 = new LectureRepo();
                lectureRepo3.deleteByld();
                break;

            default:
                System.out.println("Incorrect symbol");
        }
    }*/
}
