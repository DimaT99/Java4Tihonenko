package utils;

import entity.Student;
import repository.StudentRepo;

import java.util.Arrays;

public class StudentUtils {
    StudentRepo studentRepo = new StudentRepo();

    public void createStudent() {
        Student student = new Student();
        student.setId(Student.getCount());
        student.setName("Student" + Student.getCount());
        if (studentRepo.isEmpty()) {
            studentRepo.createStudentMas();
            studentRepo.add(Student.getCount() - 1, student);
        } else {
            Student[] students1 = Arrays.copyOf(StudentRepo.getStudents(), (studentRepo.size() * 3) / 2 + 1);
            studentRepo.addAll(students1);
            studentRepo.add(Student.getCount() - 1, student);

            }
        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }
}