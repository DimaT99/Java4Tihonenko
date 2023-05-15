import utils.ConsoleUtils;
import utils.CourseUtils;
import utils.LectureUtils;
import utils.TeacherUtils;

public class Main {
    public static void main(String[] args) {

        CourseUtils courseUtils1 = new CourseUtils();
        courseUtils1.createCourse();

        TeacherUtils teacherUtils1 = new TeacherUtils();
        teacherUtils1.createTeacher();

        LectureUtils lectureUtils1 = new LectureUtils();
        lectureUtils1.createLecture();

        ConsoleUtils consoleUtils = new ConsoleUtils();
        consoleUtils.ScannerWithSwitch();

    }
}
