package entity;

public class Additional extends SchoolSuper {
    private int id;

    public Additional(int id, String name) {
        super(id, name);
    }
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
