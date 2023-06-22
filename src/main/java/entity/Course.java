package entity;

import lombok.Data;

import java.io.Serializable;

@Data

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

    public static int getCount() {
        return count;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }
}

