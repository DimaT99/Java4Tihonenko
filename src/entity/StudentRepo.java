package entity;

public class StudentRepo extends SuperRepo{
    private static Student[] students;

    public static Student[] getStudents() {
        return students;
    }

    public void createStudentMas() {
        students = new Student[Student.getCount()];
    }
}
