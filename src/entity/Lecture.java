package entity;

public class Lecture extends SchoolSuper {
    private int courseId;
    private static int count;
    private int id;
    private String name;
    private String description;
    private int personId;

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Lecture.count = count;
    }

    public Lecture(int id, String name, int courseId, String description, int personId) {
        super(id, name);
        this.courseId = courseId;
        this.description = description;
        this.personId = personId;
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

    public Lecture() {
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

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", personId=" + personId +
                '}';
    }
}
