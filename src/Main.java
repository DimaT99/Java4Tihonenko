import utils.ConsoleUtils;
import utils.CourseUtils;
import utils.LectureUtils;
import utils.TeacherUtils;
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

        LectureUtils lectureUtils1 = new LectureUtils();
        lectureUtils1.createLecture();

        ConsoleUtils consoleUtils1 = new ConsoleUtils();
        consoleUtils.ScannerWithSwitch();

    }
}
