package entity;

public class TeacherRepo extends SuperRepo {
    private static Teacher[] teachers;

    public static Teacher[] getTeachers() {
        return teachers;
    }

    public void createTeacherMas() {
        teachers = new Teacher[1];
    }

    @Override
    public void getAll() {
        getTeachers();
        System.out.println(teachers);
    }
}
