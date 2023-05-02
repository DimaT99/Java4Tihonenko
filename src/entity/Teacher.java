package entity;

public class Teacher implements Comparable<Teacher> {
    private Integer id;
    private String name;
    private static int count;
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public static int getCount() {
        return count;
    }

    public Teacher(int id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
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
                ", person=" + person +
                '}';
    }

    @Override
    public int compareTo(Teacher o) {
        return this.getPerson().getLastName().compareTo(o.getPerson().getLastName());
    }
}
