package entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data

public class Lecture implements Serializable {
    private int courseId;
    private static int count;
    private Integer id;
    private String name;
    private String description;
    private int personId;
    private List<Homework> homeworkList;
    private String creationDate;
    private String lectureDate;
    LocalDate date;

    public List<Homework> getHomeworkList() {
        return homeworkList;
    }

    public void setHomeworkList(List<Homework> homeworkList) {
        this.homeworkList = homeworkList;
    }

    public static int getCount() {
        return count;
    }

    public Lecture() {
        count++;
    }
    public Lecture(int courseId, Integer id, String name, String description, int personId) {
        this.courseId = courseId;
        this.id = id;
        this.name = name;
        this.description = description;
        this.personId = personId;
        this.date = LocalDate.now();
        count++;
    }

    public static void sayCount() {
        System.out.println(count);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "courseId=" + courseId +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", personId=" + personId +
                ", lectureDate='" + lectureDate + '\'' +
                '}';
    }
}
