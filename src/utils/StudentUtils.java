package utils;

import entity.Student;
import repository.StudentRepo;

public class StudentUtils {
    StudentRepo studentRepo = new StudentRepo();

    public void createStudent() {
        Student student = new Student();
        student.setId(Student.getCount());
        student.setName("Student" + Student.getCount());

            studentRepo.add(student);

        for (int i = 0; i < studentRepo.size(); i++) {
            System.out.println("Index " + i + " " + studentRepo.get(i));
        }
    }
}