package entity;

public class Teacher extends SchoolSuper {
    private int id;
    private String name;
    private static int count;
    public Person person;

    public static int getCount() {
        return count;
    }

    public Teacher(int id, String name) {
        super(id, name);
        count++;
    }

    public Teacher() {
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
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }
}
