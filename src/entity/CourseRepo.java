package entity;

public class CourseRepo extends SuperRepo{
    private static Course[] courses;

    public void createCourseMas() {
       courses = new Course[Course.getCount()];
    }

    public static Course[] getCourses() {
        return courses;
    }

}
