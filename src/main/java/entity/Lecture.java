package entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
@Entity
@Data
public class Lecture implements Serializable {
    private int courseId;
    private static int count;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private int personId;
    @OneToMany(mappedBy = "lecture",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @ToString.Exclude
    private List<Homework> homeworkList;
    private String creationDate;
    private String lectureDate;
    @Transient
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

    public Lecture(String name) {
        this.name = name;
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

    public Lecture(int courseId, Integer id, String name, String description, String lectureDate) {
        this.courseId = courseId;
        this.id = id;
        this.name = name;
        this.description = description;
        this.lectureDate = lectureDate;
    }

    public Lecture(String name, Integer id) {
        this.id = id;
        this.name = name;
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
