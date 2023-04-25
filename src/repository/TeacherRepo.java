package repository;

import entity.Teacher;

import java.util.Arrays;

public class TeacherRepo implements Repo {
    private static Teacher[] teachers;

    public static Teacher[] getTeachers() {
        return teachers;
    }

    public void createTeacherMas() {
        teachers = new Teacher[Teacher.getCount()];
    }
    @Override
    public int size() {
        return teachers.length;
    }

    @Override
    public boolean isEmpty() {
        if (teachers == null) {
            return true;
        }
        return false;
    }

    @Override
    public Teacher get(int index) {
        return teachers[index];
    }

    @Override
    public void addAll(Object[] element) {
        teachers = (Teacher[]) element;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) {
            return;
        } else {
            Teacher[] teachers1 = Arrays.copyOf(teachers, (size() * 3) / 2 + 1);
            teachers1[size()] = (Teacher) element;
            teachers = teachers1;
        }
    }

    @Override
    public void add(int index, Object element) {
        teachers[index] = (Teacher) element;
    }

    @Override
    public void remove(int index) {
        if (index < teachers.length) {
            teachers[index] = null;
        } else {
            System.out.println("This index does not exist");
        }
    }
}
