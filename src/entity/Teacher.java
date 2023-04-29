package entity;

public class Teacher {
    private Integer id;
    private String name;
    private static int count;
    public Person person;

    public static int getCount() {
        return count;
    }

    public Teacher(int id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
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
