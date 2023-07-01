import repository.PostgreSqlRepo;
import utils.*;
import workLog.LogService;

public class Main {
    public static void main(String[] args) {

        //Data from PostgreSQL base, lesson 46
        PostgreSqlRepo.getAllCourse().forEach(System.out::println);
        PostgreSqlRepo.getAllLecture().forEach(System.out::println);
        PostgreSqlRepo.getAllTeacher().forEach(System.out::println);

        /*LogService.readText("src/main/java/workLog/LogSet.txt");
        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.parameterLog();

        CourseUtils courseUtils1 = new CourseUtils();
        courseUtils1.createCourse();

        TeacherUtils teacherUtils1 = new TeacherUtils();
        teacherUtils1.createTeacher();

        StudentUtils studentUtils = new StudentUtils();
        studentUtils.createStudent();

        LectureUtils lectureUtils1 = new LectureUtils();
        lectureUtils1.createLecture();

        consoleUtils.ScannerWithSwitch();*/
    }
}
