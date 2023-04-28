package repository;

import entity.Lecture;

import java.util.Arrays;

public class LectureRepo implements Repo {
    private static Lecture[] lectures;

    public static Lecture[] getLectures() {
        return lectures;
    }

    public void createLectureMas() {
        lectures = new Lecture[Lecture.getCount()];
    }

    @Override
    public int size() {
        return lectures.length;
    }

    @Override
    public boolean isEmpty() {
        if (lectures == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return lectures[index];
    }

    @Override
    public void addAll(Object[] element) {
        lectures = (Lecture[]) element;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) {
            return;
        } else {
            Lecture[] lectures1 = Arrays.copyOf(lectures, (size() * 3) / 2 + 1);
            lectures1[size()] = (Lecture) element;
            lectures = lectures1;
        }
    }

    @Override
    public void add(int index, Object element) {
        lectures[index] = (Lecture) element;
    }

    @Override
    public void remove(int index) {
        if (index < lectures.length) {
            lectures[index] = null;
        } else {
            System.out.println("This index does not exist");
        }
    }
}
