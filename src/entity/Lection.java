package entity;

public class Lection extends SchoolSuper {
    private int courseId;
    private static int count;
    private int id;
    private String name;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Lection.count = count;
    }

    public Lection(int courseId, int id, String name) {
        super(id, name);
        this.courseId = courseId;
        count++;
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

    public Lection() {
        count++;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public static void sayCount() {
        System.out.println(count);
    }


    @Override
    public String toString() {
        return "Lection{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
