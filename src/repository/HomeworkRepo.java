package repository;

import entity.Homework;

import java.util.ArrayList;
import java.util.List;

public class HomeworkRepo implements Repo {
    final private static List<Homework> homeworkArrayList = new ArrayList<>();

    public static List<Homework> getHomeworkArrayList() {
        return homeworkArrayList;
    }

    //private static Homework[] homeworks;

    @Override
    public int size() {
        return homeworkArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (homeworkArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return homeworkArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        homeworkArrayList.add((Homework) element);
    }

    @Override
    public void add(int index, Object element) {
        homeworkArrayList.set(index, (Homework) element);
    }

    @Override
    public void remove(int index) {
        homeworkArrayList.remove(homeworkArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(homeworkArrayList.toArray());
        Homework homework;
        while (simpleIterator.hasNext()) {
            homework = (Homework) simpleIterator.next();
            System.out.println(homework);
        }
        System.out.println("No homework");
        return;
    }
}
