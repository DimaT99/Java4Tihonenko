package repository;

import entity.Course;

import java.util.Arrays;

public class CourseRepo implements Repo {
    private static Course[] courses;

    public static Course[] getCourses() {
        return courses;
    }

    public void createCourseMas() {
        courses = new Course[Course.getCount()];
    }

    @Override
    public int size() {
        return courses.length;
    }

    @Override
    public boolean isEmpty() {
        if (courses == null) {
            return true;
        }
        return false;
    }

    @Override
    public Object get(int index) {
        return courses[index];
    }

    @Override
    public void addAll(Object[] element) {
        courses = (Course[]) element;
    }

    @Override
    public void add(Object element) {
        if (isEmpty()) {
            return;
        } else {
            Course[] courses1 = Arrays.copyOf(courses, (size() * 3) / 2 + 1);
            courses1[size()] = (Course) element;
            courses = courses1;
        }
    }

    @Override
    public void add(int index, Object element) {
        courses[index] = (Course) element;
    }

    @Override
    public void remove(int index) {
        if (index < courses.length) {
            courses[index] = null;
        } else {
            System.out.println("This index does not exist");
        }
    }

    @Override
    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(getCourses());
        Course course;
        while (simpleIterator.hasNext()) {
            course = (Course) simpleIterator.next();
            System.out.println(course);
        }
        return;
    }
}
