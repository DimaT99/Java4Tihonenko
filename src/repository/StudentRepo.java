package repository;

import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements Repo {
    final private static List<Student> studentArrayList = new ArrayList<>();
    //private static Student[] students;

    @Override
    public int size() {
        return studentArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (studentArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return studentArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        studentArrayList.add((Student) element);
    }

    @Override
    public void add(int index, Object element) {
        studentArrayList.set(index, (Student) element);
    }

    @Override
    public void remove(int index) {
        studentArrayList.remove(studentArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(studentArrayList.toArray());
        Student student;
        while (simpleIterator.hasNext()) {
            student = (Student) simpleIterator.next();
            System.out.println(student);
        }
        System.out.println("No student");
        return;
    }
}
