package entity;

public class Lection extends SchoolSuper {
    private int courseId;

    public static int count;
    private int id;
    private String name;

    public Lection(int id, String name) {
        super(id, name);
        count++;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
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

   /* public Lection(int courseId, int id, String name) {
        this.courseId = courseId;
        this.id = id;
        this.name = name;
        count++;
    }

    public Lection() {
        count++;
    }*/

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
