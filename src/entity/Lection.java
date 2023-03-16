package entity;

public class Lection {

    public static int count;
    private int id;
    private String name;

    public Lection(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Lection() {
        count++;
    }
    public static void sayCount() {
        System.out.println(count);
    }
}
