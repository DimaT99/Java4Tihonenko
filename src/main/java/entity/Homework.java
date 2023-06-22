package entity;

import java.io.Serializable;

public class Homework implements Serializable {
    private Integer id;
    private int lectureId;
    private String task;
    private static int count;
    private String deadline;

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
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLectureId() {
        return lectureId;
    }

    public void setLectureId(int lectureId) {
        this.lectureId = lectureId;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
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
