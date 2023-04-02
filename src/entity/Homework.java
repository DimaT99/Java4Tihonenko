package entity;

public class Homework extends SchoolSuper {
    private int id;

    public Homework(int id, String name) {
        super(id, name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
