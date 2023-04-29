package repository;

import entity.Homework;

import java.util.Arrays;

public class HomeworkRepo implements Repo {
    private static Homework[] homeworks;

    public void createHomeworkMas() {
        homeworks = new Homework[Homework.getCount()];
    }

    public static Homework[] getHomeworks() {
        return homeworks;
    }

    @Override
    public int size() {
        return homeworks.length;
    }

    @Override
    public boolean isEmpty() {
        if (homeworks == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return homeworks[index];
    }

    @Override
    public void addAll(Object[] element) {
        homeworks = (Homework[]) element;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) {
            return;
        } else {
            Homework[] homeworks1 = Arrays.copyOf(homeworks, (size() * 3) / 2 + 1);
            homeworks1[size()] = (Homework) element;
            homeworks = homeworks1;
        }
    }

    @Override
    public void add(int index, Object element) {
        homeworks[index] = (Homework) element;
    }

    @Override
    public void remove(int index) {
        if (index < homeworks.length) {
            homeworks[index] = null;
        } else {
            System.out.println("This index does not exist");
        }
    }

    @Override
    public void findAll() {
        return;
    }
}
