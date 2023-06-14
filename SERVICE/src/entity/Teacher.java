package entity;

import java.io.Serializable;

public class Teacher implements Serializable {
    private Integer id;
    private String name;
    private static int count;

    public static int getCount() {
        return count;
    }

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
        count++;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher() {
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
