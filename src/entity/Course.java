package entity;

public class Course extends SchoolSuper {
    private static int count;
    private int id;
    private String name;
    public Course(int id, String name) {
        super(id, name);
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Course.count = count;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

