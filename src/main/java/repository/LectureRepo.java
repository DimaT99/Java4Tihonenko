package repository;

import entity.Lecture;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Component
public class LectureRepo implements Repo {
    private static List<Lecture> lectureArrayList = new ArrayList<>();
    //private static Lecture[] lectures;

    public static List<Lecture> getLectureArrayList() {
        return lectureArrayList;
    }

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
    public static <T> List<T> filter(List<T> list, Predicate<T> func) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (func.test(t))
                result.add(t);
        }
        return result;
    }
    public void filterLectures() {
        List<Lecture> result = filter(lectureArrayList, a -> a.getDate().isAfter(LocalDate.now().plusDays(3)));
        System.out.println("\n" + "List of lectures from the specified date - " + LocalDate.now().plusDays(3));
        result.forEach((s) -> System.out.println(s));
        result = filter(lectureArrayList, a -> a.getDate().isBefore(LocalDate.now().plusDays(3)));
        System.out.println("\n" + "List of lectures by the specified date - " + LocalDate.now().plusDays(3));
        result.forEach((s) -> System.out.println(s));
        Predicate<Lecture> func1 = a -> a.getDate().isAfter(LocalDate.now().plusDays(1));
        Predicate<Lecture> func2 = a -> a.getDate().isBefore(LocalDate.now().plusDays(5));
        result = filter(lectureArrayList, func1.and(func2));
        System.out.println("\n" + "List of lectures between the specified dates " + LocalDate.now().plusDays(2) + " to " + LocalDate.now().plusDays(4));
        result.forEach((s) -> System.out.println(s));
    }
    public Lecture getLectureByLectureName(String lectureName) throws Exception{
        return lectureArrayList.stream()
                .filter(lecture -> lecture.getName().equals(lectureName))
                .findAny()
                .orElse(null);
    }
}
