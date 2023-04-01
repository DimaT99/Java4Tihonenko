package utils;

import entity.Student;
import entity.StudentRepo;

public class StudentUtils {
    public void createStudent() {
        Student student = new Student(1, "Student");
        student.setId(1);
        student.setName("Student");
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.createStudentMas();
        StudentRepo.getStudents()[0] = student;
        System.out.println(StudentRepo.getStudents()[0]);
    }
}
