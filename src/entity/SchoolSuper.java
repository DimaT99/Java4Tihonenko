package entity;

public class SchoolSuper {
    private int id;
    private String name;

    public SchoolSuper(int id, String name) {
        this.id = id;
        this.name = name;
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
        return "SchoolSuper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void createObject() {
        SchoolSuper schoolSuper = new SchoolSuper(1, "SchoolSuper");
    }
}
