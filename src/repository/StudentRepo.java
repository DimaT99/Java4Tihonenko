package repository;

import entity.Student;

import java.util.Arrays;

public class StudentRepo implements Repo {
    private static Student[] students;

    public static Student[] getStudents() {
        return students;
    }

    public void createStudentMas() {
        students = new Student[Student.getCount()];
    }

    @Override
    public int size() {
        return students.length;
    }

    @Override
    public boolean isEmpty() {
        if (students == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return students[index];
    }

    @Override
    public void addAll(Object[] element) {
        students = (Student[]) element;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) {
            return;
        } else {
            Student[] students1 = Arrays.copyOf(students, (size() * 3) / 2 + 1);
            students1[size()] = (Student) element;
            students = students1;
        }
    }

    @Override
    public void add(int index, Object element) {
        students[index] = (Student) element;
    }

    @Override
    public void remove(int index) {
        if (index < students.length) {
            students[index] = null;
        } else {
            System.out.println("This index does not exist");
        }
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(getStudents());
        Student student;
        while (simpleIterator.hasNext()) {
            student = (Student) simpleIterator.next();
            System.out.println(student);
        }
        return;
    }
}
