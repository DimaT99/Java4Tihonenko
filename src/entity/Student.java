package entity;

public class Student extends SchoolSuper {
    private int id;
    private String name;
    private static int count;

    public Student(int id, String name) {
        super(id, name);
        count++;
    }

    public Student() {
        count++;
    }

    public static int getCount() {
        return count;
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
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
