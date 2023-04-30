package repository;

import entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherRepo implements Repo{
    final private static List<Teacher> teacherArrayList = new ArrayList<>();

    //private static Teacher[] teachers;


    public int size() {
        return teacherArrayList.size();
    }

    public Teacher get(int index) {
        return teacherArrayList.get(index);
    }

    @Override
    public void add(Object element) {
        teacherArrayList.add((Teacher) element);
    }

    @Override
    public void add(int index, Object element) {
        teacherArrayList.set(index, (Teacher) element);
    }

    @Override
    public void remove(int index) {
        teacherArrayList.remove(teacherArrayList.get(index));
    }

    public boolean isEmpty() {
        if (teacherArrayList.isEmpty()) {
            return true;
        }
        return false;
    }

    public void remove(Teacher teacher) {
        teacherArrayList.remove(teacher);
    }

    public void findAll() {
        SimpleIterator simpleIterator = new SimpleIterator(teacherArrayList.toArray());
        Teacher teacher;
        while (simpleIterator.hasNext()) {
            teacher = (Teacher) simpleIterator.next();
            System.out.println(teacher);
        }
        System.out.println("No teacher");
        return;
    }
}
