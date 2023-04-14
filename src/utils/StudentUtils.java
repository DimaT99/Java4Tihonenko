package utils;

import entity.Repo;
import entity.Student;
import entity.Teacher;

import java.util.Arrays;

public class StudentUtils {
    Repo<Student> studentRepo = new Repo<>();

    public void createStudent() {
        Student student = new Student();
        student.setId(Student.getCount());
        student.setName("Student" + Student.getCount());
        if (studentRepo.isEmpty()) {
            Student[] students = new Student[Student.getCount()];
            students[0] = student;
            studentRepo.addAll(students);
        } else {
            Student[] students = Arrays.copyOf(studentRepo.getEntityArray(), (studentRepo.size() * 3) / 2 + 1);
            for (int i = studentRepo.size(); i < students.length; i++) {
                students[i] = student;
                Student[] students1 = new Student[Student.getCount()];
                for (int a = 0; a < studentRepo.size(); a++) {
                    students1[a] = students[a];
                }
                studentRepo.addAll(students1);
            }
        }
        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }
}