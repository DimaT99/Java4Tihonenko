package utils;

import entity.Student;
import entity.StudentRepo;

public class StudentUtils {
    public void createStudent() {
        Student student = new Student();
        StudentRepo studentRepo = new StudentRepo();
        studentRepo.createStudentMas();
        StudentRepo.students[0] = student;
        System.out.println(StudentRepo.students[0]);
    }
}
