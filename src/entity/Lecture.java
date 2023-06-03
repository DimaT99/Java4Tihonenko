package entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
    public static int getCount() {
        return count;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLectureDate() {
        return lectureDate;
    }
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setLectureDate(String lectureDate) {
        this.lectureDate = lectureDate;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
