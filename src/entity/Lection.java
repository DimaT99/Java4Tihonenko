package entity;

public class Lection {
    public int courseId;

    public static int count;
    private int id;
    private String name;

    public Lection(int courseId, int id, String name) {
        this.courseId = courseId;
        this.id = id;
        this.name = name;
        count++;
    }

    public Lection() {
        count++;
    }

    public static void sayCount() {
        System.out.println(count);
    }
}
