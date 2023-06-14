package entity;

import java.io.Serializable;

public class Course implements Comparable<Course>, Serializable {
    private static int count;
    private Integer id;
    private String name;

    public Course() {
        count++;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}

