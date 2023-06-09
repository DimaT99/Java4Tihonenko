package utils;

import entity.Additional;
import entity.Homework;
import entity.Lecture;
import entity.ResourceType;
import examination.MyThreads;
import repository.*;
import serialization.Serializer;
import workLog.LogService;
import workLog.LogUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ConsoleUtils {
    LogUtils logUtils = new LogUtils();

    public void ScannerWithSwitch() {

        LogUtils.className = ConsoleUtils.class;
        Scanner scanner = new Scanner(System.in);
        int category = 0;
        boolean stop = true;
        while (stop) {
            do {
                System.out.println("Select category:");
                System.out.println("1. Create Course");
                System.out.println("2. Create Teacher");
                System.out.println("3. Create Student");
                System.out.println("4. Create Lecture");
                System.out.println("5. Additional materials menu");
                System.out.println("6. Output of created objects");
                System.out.println("7. Lecture menu");
                System.out.println("8. View to Log");
                System.out.println("9. Start the exam");
                System.out.println("10. Select the LOG option");
                System.out.println("11. View deserialized data");
                System.out.println("12. Teacher sort list");
                System.out.println("13. Print Teacher Map");
                System.out.println("14. Write e-mail of students in a file");
                System.out.println("15. Exit");

                try {
                    category = scanner.nextInt();
                } catch (Exception e) {
                    /*StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        System.out.println(stackTraceElement);}*/

                    logUtils.error("Incorrect symbol", e.getStackTrace());
                    System.out.println("Incorrect symbol. Choose the right category");
                    ScannerWithSwitch();
                    return;
                }
            } while (category < 1 || category > 15);
            logUtils.debug("Select category");
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
                    //studentUtils.addStudent();               //optional wrapper lesson 29
                    break;
                case 4:
                    System.out.println("Category Lecture");
                    LogUtils.className = LectureUtils.class;
                    logUtils.info("Category Lecture");
                    LectureUtils lectureUtils = new LectureUtils();
                    lectureUtils.createLecture();
                    break;
                case 5:
                    System.out.println("Category Additional materials");

                    int category1 = 0;
                    do {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Select a category to work with Additional materials, please use only numbers from 1 to 5");
                        System.out.println("1. Create object Additional materials");
                        System.out.println("2. Sort by id");
                        System.out.println("3. Sort by lecture");
                        System.out.println("4. Sort by resource type");
                        System.out.println("5. Sort by lecture (stream)");
                        try {
                            category1 = scanner1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                            System.out.println("Incorrect symbol. Choose the right category");
                        }
                    } while (category1 < 1 || category1 > 5);
                    AdditionalRepo additionalRepo = new AdditionalRepo();
                    switch (category1) {
                        case 1:
                            System.out.println("Create object Additional materials");
                            AdditionalUtils additionalUtils = new AdditionalUtils();
                            additionalUtils.createAdditional();
                            break;
                        case 2:
                            System.out.println("Sorted from id");
                            AdditionalRepo.getAdditionalArrayList().sort(null);
                            additionalRepo.findAll();
                            break;
                        case 3:
                            System.out.println("Sort by lecture");
                            AdditionalRepo.getAdditionalArrayList().sort((Additional o1, Additional o2) ->
                                    o1.getLectureId() - o2.getLectureId());
                            additionalRepo.findAll();
                            break;
                        case 4:
                            System.out.println("Sort by resource type");
                            Comparator<Additional> comparator1 = new Comparator<Additional>() {
                                @Override
                                public int compare(Additional o1, Additional o2) {
                                    return o1.getResourceType().compareTo(o2.getResourceType());
                                }
                            };
                            AdditionalRepo.getAdditionalArrayList().sort(comparator1);
                            additionalRepo.findAll();
                            break;
                        case 5:
                            System.out.println("Sort by lecture (stream)");
                            Map<String, List<Additional>> additionalByLecture = LectureRepo.getLectureArrayList().stream()
                                    .collect(Collectors.toMap(
                                            lecture -> lecture.getName(),
                                            lecture -> AdditionalRepo.getAdditionalMap().get(lecture.getId())));
                            additionalByLecture.entrySet().forEach(System.out::println);
                            break;
                        default:
                            System.out.println("No such category exist");
                    }
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
                    System.out.println("View to Log");
                    int category7 = 0;
                    do {
                        Scanner scanner1 = new Scanner(System.in);
                        System.out.println("Select a category to work with Log, please use only numbers from 1 to 3");
                        System.out.println("1. View to Log");
                        System.out.println("2. View to message from Log");
                        System.out.println("3. View the number of messages from the log");
                        try {
                            category7 = scanner1.nextInt();
                        } catch (Exception e) {
                            System.out.println(e);
                            System.out.println("Incorrect symbol. Choose the right category");
                        }
                    } while (category7 < 1 || category7 > 3);
                    LogService logService = new LogService();
                    switch (category7) {
                        case 1:
                            System.out.println("View to Log");
                            LogService.writeLog("src/main/java/workLog/Log.txt");
                            logService.readToFile("src/main/java/workLog/Log.txt");
                            break;
                        case 2:
                            System.out.println("View to message from Log");
                            LogService.writeToFile();
                            try {
                                List<String> logList = Files.readAllLines(Path.of("src/main/java/workLog/Log.txt"));
                                logList.stream()
                                        .filter(log -> log.contains("Message"))
                                        .forEach(System.out::println);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        case 3:
                            System.out.println("View the number of messages from the log");
                            LogService.writeToFile();
                            try {
                                List<String> logList = Files.readAllLines(Path.of("src/main/java/workLog/Log.txt"));
                                long info = logList.stream()
                                        .filter(s -> s.contains("INFO"))
                                        .count();
                                List<String> logList2 = new ArrayList<>();
                                for (int i = logList.size() / 2; i < logList.size(); i++) {
                                    logList2.add(logList.get(i));
                                }
                                long info1 = logList2.stream()
                                        .filter(s -> s.contains("INFO"))
                                        .count();

                                System.out.println("All logs with level INFO = " + info);
                                System.out.println("The number of messages from half the loglevel INFO = " + info1);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                            break;
                        default:
                            System.out.println("No such category exist");
                    }
                    break;
                case 9:
                    System.out.println("Exam");
                    MyThreads.myThreads();
                    break;
                case 10:
                    //System.out.println("Select parameter LOG");
                    parameterLog();
                    break;
                case 11:
                    System.out.println("View deserialized data - course backup");
                    Serializer.serialization("src/main/java/serialization/courseBackup.data");
                    Serializer.deserialization("src/main/java/serialization/courseBackup.data");
                    break;
                case 12:
                    System.out.println("Teacher sort list");
                    TeacherUtils teacherUtils1 = new TeacherUtils();
                    teacherUtils1.teacherListLastname();
                    break;
                case 13:
                    System.out.println("Print Teacher Map");
                    Map<String, String> teacherMap = TeacherRepo.getTeacherArrayList().stream()
                            .collect(Collectors.toMap(
                                    teacher -> teacher.getPerson().getEmail(),
                                    teacher -> teacher.getPerson().getFirstName() + " " + teacher.getPerson().getLastName()
                            ));
                    teacherMap.entrySet().forEach(System.out::println);
                    break;
                case 14:
                    System.out.println("Write e-mail of students in a file");

                    String fileName = "src/main/java/email.txt";
                    try (FileOutputStream fos = new FileOutputStream(fileName, false)) { }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    StudentRepo.getStudentArrayList().stream()
                            .map(student -> student.getPerson().getEmail())
                            .sorted(String::compareTo)
                            .forEach(s -> {
                                try (FileOutputStream out = new FileOutputStream(fileName, true);
                                     Writer file = new OutputStreamWriter(out)) {
                                    file.append(s + "\n");
                                } catch (IOException e) {
                                }
                            });
                    LogService logService1 = new LogService();
                    logService1.readToFile("src/main/java/email.txt");
                    break;
                case 15:
                    stop = false;
                    logUtils.info("Exit");
                    LogService.writeToFile();
                    break;
                default:
                    System.out.println("No such category exist");
            }
        }
    }

    public void outputObject() {

        int category3;
        final Scanner scanner1 = new Scanner(System.in);
        System.out.println("Select the category of created objects, please use only numbers from 1 to 6");
        System.out.println("1. Created objects Course");
        System.out.println("2. Created objects Teacher");
        System.out.println("3. Created objects Student");
        System.out.println("4. Created objects Lecture");
        System.out.println("5. Created objects Homework");
        System.out.println("6. Created objects Additional");
        category3 = scanner1.nextInt();

        switch (category3) {
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
                HomeworkRepo.getHomeworkMap();
                for (int i = 1; i < HomeworkRepo.getHomeworkMap().size() + 1; i++) {
                    System.out.println(HomeworkRepo.getHomeworkMap().get(i));
                }
                break;
            case 6:
                System.out.println("Created objects Additional");
                AdditionalRepo additionalRepo = new AdditionalRepo();
                additionalRepo.findAll();
                AdditionalRepo.getAdditionalMap();
                for (int i = 1; i < AdditionalRepo.getAdditionalMap().size() + 1; i++) {
                    System.out.println(AdditionalRepo.getAdditionalMap().get(i));
                }
                break;
            default:
                System.out.println("Incorrect symbol");
        }
    }

    public void lectionJobs() {

        int category4 = 0;
        int idLecture = 0;
        LectureUtils lectureUtils = new LectureUtils();
        LectureRepo lectureRepo = new LectureRepo();
        do {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Select the category, please use only numbers from 1 to 10");
            System.out.println("1. Return an array");
            System.out.println("2. Add a new lecture");
            System.out.println("3. Open the selected lecture");
            System.out.println("4. Delete the selected lecture");
            System.out.println("5. Watch homework from lecture");
            System.out.println("6. Watch additional materials from lecture");
            System.out.println("7. List of lectures by date");
            System.out.println("8. Filter lecture");
            System.out.println("9. Sort lecture by teacher");
            System.out.println("10. Main menu");
            try {
                category4 = scanner2.nextInt();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Incorrect symbol. Choose the right category");
            }
        } while (category4 < 1 || category4 > 10);
        switch (category4) {
            case 1:
                System.out.println("Return an array");
                lectureUtils.getAll();
                lectionJobs();
                break;
            case 2:
                System.out.println("Add a new lecture");
                lectureUtils.add();
                lectionJobs();
                break;
            case 3:
                System.out.println("Open the selected lecture, enter ID lectures");
                Scanner scanner3 = new Scanner(System.in);
                try {
                    idLecture = scanner3.nextInt();
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Incorrect symbol. Choose the right category");
                }
                lectureUtils.getByld(idLecture);
                lectionJobs();
                break;
            case 4:
                System.out.println("Delete the selected lecture, enter ID lectures");
                Scanner scanner4 = new Scanner(System.in);
                try {
                    idLecture = scanner4.nextInt();
                    lectureUtils.deleteByld(idLecture);
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Incorrect symbol. Choose the right category");
                }
                lectionJobs();
                break;
            case 5:
                System.out.println("Watch homework from lecture");
                lectureRepo.findAll();
                System.out.println("Enter ID of the selected lecture");
                Scanner scanner7 = new Scanner(System.in);
                try {
                    idLecture = scanner7.nextInt();
                    if (HomeworkRepo.getHomeworkMap().get(idLecture) == null) {
                        System.out.println("ID does not exist");
                    } else {
                        List<Homework> homework1 = HomeworkRepo.getHomeworkMap().get(idLecture);
                        for (Homework homework2 : homework1) {
                            System.out.println(homework2.toString());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Incorrect symbol. Choose the right category");
                    lectionJobs();
                    break;
                }
                int category5 = 0;
                do {
                    System.out.println("1. Add new homework");
                    System.out.println("2. Delete homework");
                    System.out.println("3. Lecture menu");
                    Scanner scanner5 = new Scanner(System.in);
                    try {
                        category5 = scanner5.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Incorrect symbol. Choose the right category");
                    }
                } while (category5 < 1 || category5 > 3);
                switch (category5) {
                    case 1:
                        System.out.println("Add new homework");
                        Homework homework = new Homework(Homework.getCount() + 1, idLecture, "Task" + (Homework.getCount() + 1));
                        HomeworkRepo homeworkRepo = new HomeworkRepo();
                        homeworkRepo.add(homework);
                        homeworkRepo.addMap(homework);
                        List<Homework> homework1 = HomeworkRepo.getHomeworkMap().get(idLecture);
                        for (Homework homework2 : homework1) {
                            System.out.println(homework2.toString());
                        }
                        lectionJobs();
                        return;
                    case 2:
                        System.out.println("Delete homework");
                        Scanner scanner6 = new Scanner(System.in);
                        int idHomework;
                        try {
                            do {
                                System.out.println("Enter an existing homework ID");
                                idHomework = scanner6.nextInt();
                            } while (idHomework > Homework.getCount());
                            if (HomeworkRepo.getHomeworkMap().get(idLecture) == null) {
                                System.out.println("ID does not exist");
                            } else {
                                for (int i = 0; i < HomeworkRepo.getHomeworkMap().get(idLecture).size(); i++) {
                                    if (HomeworkRepo.getHomeworkMap().get(idLecture).get(i).getId() == idHomework) {
                                        HomeworkRepo.getHomeworkMap().get(idLecture).remove(i);
                                        for (i = 0; i < HomeworkRepo.getHomeworkArrayList().size(); i++) {
                                            if (HomeworkRepo.getHomeworkArrayList().get(i).getId() == idHomework) {
                                                HomeworkRepo.getHomeworkArrayList().remove(i);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                            System.out.println("Incorrect symbol. Choose the right category");
                        }
                        List<Homework> homework2 = HomeworkRepo.getHomeworkMap().get(idLecture);
                        for (Homework homework3 : homework2) {
                            System.out.println(homework3.toString());
                        }
                        lectionJobs();
                        return;
                    case 3:
                        lectionJobs();
                        return;
                }
            case 6:
                System.out.println("Watch additional materials from lecture");
                lectureRepo.findAll();
                System.out.println("Enter ID of the selected lecture");
                Scanner scanner8 = new Scanner(System.in);
                try {
                    idLecture = scanner8.nextInt();
                    if (AdditionalRepo.getAdditionalMap().get(idLecture) == null) {
                        System.out.println("ID does not exist");
                    } else {
                        ArrayList<Additional> additionals = AdditionalRepo.getAdditionalMap().get(idLecture);
                        for (Additional additional : additionals) {
                            System.out.println(additional.toString());
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Incorrect symbol. Choose the right category");
                    lectionJobs();
                    break;
                }
                int category6 = 0;
                do {
                    System.out.println("1. Add new additional materials");
                    System.out.println("2. Delete additional materials");
                    System.out.println("3. Lecture menu");
                    Scanner scanner6 = new Scanner(System.in);
                    try {
                        category6 = scanner6.nextInt();
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("Incorrect symbol. Choose the right category");
                    }
                } while (category6 < 1 || category6 > 3);
                switch (category6) {
                    case 1:
                        System.out.println("Add new additional materials");
                        Additional additional = new Additional(Additional.getCount() + 1, "Additional" + (Additional.getCount() + 1),
                                idLecture, (ResourceType) ResourceType.resourceType());
                        AdditionalRepo additionalRepo = new AdditionalRepo();
                        additionalRepo.add(additional);
                        additionalRepo.addMap(additional);
                        ArrayList<Additional> additionals = AdditionalRepo.getAdditionalMap().get(idLecture);
                        for (Additional additional1 : additionals) {
                            System.out.println(additional1.toString());
                        }
                        lectionJobs();
                        return;
                    case 2:
                        System.out.println("Delete additional materials");
                        Scanner scanner9 = new Scanner(System.in);
                        int idAdditional;
                        try {
                            do {
                                System.out.println("Enter an existing additional materials ID");
                                idAdditional = scanner9.nextInt();
                            } while (idAdditional > Additional.getCount());
                            if (AdditionalRepo.getAdditionalMap().get(idLecture) == null) {
                                System.out.println("ID does not exist");
                            } else {
                                for (int i = 0; i < AdditionalRepo.getAdditionalMap().get(idLecture).size(); i++) {
                                    if (AdditionalRepo.getAdditionalMap().get(idLecture).get(i).getId() == idAdditional) {
                                        AdditionalRepo.getAdditionalMap().get(idLecture).remove(i);
                                        for (i = 0; i < AdditionalRepo.getAdditionalArrayList().size(); i++) {
                                            if (AdditionalRepo.getAdditionalArrayList().get(i).getId() == idAdditional) {
                                                AdditionalRepo.getAdditionalArrayList().remove(i);
                                            }
                                        }
                                    }
                                }
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                            System.out.println("Incorrect symbol. Choose the right category");
                        }
                        ArrayList<Additional> additionals1 = AdditionalRepo.getAdditionalMap().get(idLecture);
                        for (Additional additional1 : additionals1) {
                            System.out.println(additional1.toString());
                        }

                        lectionJobs();
                        return;
                    case 3:
                        lectionJobs();
                        return;
                }
            case 7:
                System.out.println("List of lectures by date");
                lectureRepo.filterLectures();
                lectionJobs();
                break;
            case 8:
                System.out.println("Filter lecture");
                lectureUtils.lectureSearch();
                lectionJobs();
                break;
            case 9:
                System.out.println("Sort lecture by teacher");
                Map<String, List<Lecture>> lectureByTeacher = LectureRepo.getLectureArrayList().stream()
                        .collect(Collectors.groupingBy(lecture -> TeacherRepo.getTeacherArrayList().get(lecture.getPersonId() - 1).getName()));
                lectureByTeacher = lectureByTeacher.entrySet().stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue,
                                LinkedHashMap::new));
                lectureByTeacher.entrySet().forEach(System.out::println);
                lectionJobs();
                break;
            case 10:
                break;
            default:
                System.out.println("Incorrect symbol");

        }
    }

    public void parameterLog() {

        int category7 = 0;
        final Scanner scanner8 = new Scanner(System.in);
        do {
            System.out.println("Select parameter LOG, please use only numbers from 1 to 5");
            System.out.println("1. DEBUG");
            System.out.println("2. INFO");
            System.out.println("3. WARNING");
            System.out.println("4. ERROR");
            System.out.println("5. OFF");
            try {
                category7 = scanner8.nextInt();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println("Incorrect symbol. Choose the right category");
                parameterLog();
                return;
            }
        } while (category7 < 1 || category7 > 5);
        switch (category7) {
            case 1:
                System.out.println("Level selected DEBUG");
                LogService.writeLogSet("DEBUG", "src/main/java/workLog/LogSet.txt");
                break;
            case 2:
                System.out.println("Level selected INFO");
                LogService.writeLogSet("INFO", "src/main/java/workLog/LogSet.txt");
                break;
            case 3:
                System.out.println("Level selected WARNING");
                LogService.writeLogSet("WARNING", "src/main/java/workLog/LogSet.txt");
                break;
            case 4:
                System.out.println("Level selected ERROR");
                LogService.writeLogSet("ERROR", "src/main/java/workLog/LogSet.txt");
                break;
            case 5:
                System.out.println("Level selected OFF");
                LogService.writeLogSet("OFF", "src/main/java/workLog/LogSet.txt");
                break;
            default:
                System.out.println("Incorrect symbol");
        }
    }
}