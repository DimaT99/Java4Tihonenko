package entity;

public class Course {
    public static int count;
    private int id;
    private String name;

    public Course(int id) {
        this.id = id;
        count++;
    }

    public Course() {
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                '}';
    }
}

