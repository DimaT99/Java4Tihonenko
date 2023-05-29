import utils.*;
import workLog.LogService;

public class Main {
    public static void main(String[] args) {

        LogService.readText("src/workLog/LogSet.txt");
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

        consoleUtils.ScannerWithSwitch();
    }
}
