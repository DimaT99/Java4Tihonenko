package repository;

import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepo implements Repo {
    final private static List<Course> courseArrayList = new ArrayList<>();

    @Override
    public int size() {
        return courseArrayList.size();
    }

    @Override
    public boolean isEmpty() {
        if (courseArrayList == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return courseArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        courseArrayList.add((Course) element);
    }

    @Override
    public void add(int index, Object element) {
        courseArrayList.set(index, (Course) element);
    }

    @Override
    public void remove(int index) {
        courseArrayList.remove(courseArrayList.get(index));
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(courseArrayList.toArray());
        Course course;
        while (simpleIterator.hasNext()) {
            course = (Course) simpleIterator.next();
            System.out.println(course);
        }
        System.out.println("All course");
        return;
    }
}
