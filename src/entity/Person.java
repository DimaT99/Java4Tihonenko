package entity;

public class Person {
    private static int count;
    private int id;
    private int courseId;
    private EnumRole enumRole;

    public Person(int id, int courseId, EnumRole enumRole) {
        this.id = id;
        this.courseId = courseId;
        this.enumRole = enumRole;
        count++;
    }

    public Person() {
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

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public EnumRole getEnumRole() {
        return enumRole;
    }

    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", enumRole=" + enumRole +
                '}';
    }
}
