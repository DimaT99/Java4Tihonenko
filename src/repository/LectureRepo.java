package repository;

import entity.Lecture;

import java.util.ArrayList;
import java.util.List;

public class LectureRepo implements Repo {
    final private static List<Lecture> lectureArrayList = new ArrayList<>();
    //private static Lecture[] lectures;

    @Override
    public int size() {
        return lectureArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (lectureArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return lectureArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        lectureArrayList.add((Lecture) element);
    }

    @Override
    public void add(int index, Object element) {
        lectureArrayList.set(index, (Lecture) element);
    }

    @Override
    public void remove(int index) {
        lectureArrayList.remove(lectureArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(lectureArrayList.toArray());
        Lecture lecture;
        while (simpleIterator.hasNext()) {
            lecture = (Lecture) simpleIterator.next();
            System.out.println(lecture);
        }
        System.out.println("All lecture");
        return;
    }
}
