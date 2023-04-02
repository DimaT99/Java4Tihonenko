package entity;

public class Student extends SchoolSuper {
    private int id;
    private String name;

    public Student(int id, String name) {
        super(id, name);
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
}
