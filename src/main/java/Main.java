import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.*;
import workLog.LogService;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ConsoleUtils consoleUtils = context.getBean(ConsoleUtils.class);
        CourseUtils courseUtils = context.getBean(CourseUtils.class);
        TeacherUtils teacherUtils = context.getBean(TeacherUtils.class);
        StudentUtils studentUtils = context.getBean(StudentUtils.class);
        LectureUtils lectureUtils = context.getBean(LectureUtils.class);

        /*//Data from PostgreSQL base, lesson 47
        PostgreSqlRepo.getAllCourse().forEach(System.out::println);
        PostgreSqlRepo.getAllLecture().forEach(System.out::println);
        PostgreSqlRepo.getAllTeacher().forEach(System.out::println);

        PostgreSqlRepo.insertColumns();*/

        LogService.readText("src/main/java/workLog/LogSet.txt");
        consoleUtils.parameterLog();

        courseUtils.createCourse();

        teacherUtils.createTeacher();

        studentUtils.createStudent();

        lectureUtils.createLecture();

        consoleUtils.ScannerWithSwitch();
    }
}