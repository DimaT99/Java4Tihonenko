package utils;

import entity.Student;
import entity.StudentRepo;
import entity.Teacher;

import java.util.Arrays;

public class StudentUtils {
    public void createStudent() {
        Student student = new Student();
        student.setId(Student.getCount());
        student.setName("Student" + Student.getCount());
        if (Student.getCount() == 1) {
            StudentRepo studentRepo = new StudentRepo();
            studentRepo.createStudentMas();
            StudentRepo.getStudents()[0] = student;
        } else {
            Student[] students = Arrays.copyOf(StudentRepo.getStudents(), StudentRepo.getStudents().length + Student.getCount());
            for (int i = StudentRepo.getStudents().length; i < students.length; i++) {
                students[i] = student;
                StudentRepo studentRepo = new StudentRepo();
                studentRepo.createStudentMas();
                for (int a = 0; a < StudentRepo.getStudents().length; a++) {
                    StudentRepo.getStudents()[a] = students[a];
                }
            }
        }
        for (int i = 0; i < StudentRepo.getStudents().length; i++) {
            System.out.println("Index " + i + " " + StudentRepo.getStudents()[i]);
        }
    }
}