package entity;

import lombok.Data;
import lombok.ToString;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Homework implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private int lectureId;
    private String task;
    private static int count;
    private String deadline;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lecture_id", referencedColumnName = "id")
    @ToString.Exclude
    private Lecture lecture;

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public static int getCount() {
        return count;
    }

    public Homework() {
        count++;
    }

    public Homework(int id, int lectureId, String task) {
        this.id = id;
        this.lectureId = lectureId;
        this.task = task;
        count++;
    }

    @Override
    public String toString() {
        return "Homework{" +
                "id=" + id +
                ", lectureId=" + lectureId +
                ", task='" + task + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
