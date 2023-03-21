import entity.Course;
import entity.Lection;
import utils.AdditionalUtils;
import utils.CourseUtils;
import utils.LectionUtils;

public class Main {
    public static void main(String[] args) {

        Course course = new Course(555);
        int courseId = course.getId();
        Lection lection1 = new Lection(courseId, 1, "Lection 1");
        Lection lection2 = new Lection(courseId, 2, "Lection 2");
        Course course1 = new Course(666);
        int course1Id = course1.getId();
        Lection lection3 = new Lection(course1Id, 3, "Lection 3");
        Lection lection4 = new Lection(course1Id, 4, "Lection 4");
        Course course2 = new Course(777);
        int course2Id = course2.getId();
        Lection lection5 = new Lection(course2Id, 5, "Lection 5");
        Lection lection6 = new Lection(course2Id, 6, "Lection 6");

        Lection.sayCount();
        System.out.println(lection6.courseId);

        CourseUtils courseUtils = new CourseUtils();
        courseUtils.ScannerWithSwitch();
        LectionUtils lectionUtils = new LectionUtils();
        lectionUtils.createLectionConsole();
    }
}
