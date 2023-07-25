package entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Data
public class Student implements Comparable<Student>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private static int count;
    @Transient
    private Person person;
    private Integer courseId;
    private Integer sum;

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public Student(Integer id, String name, Person person) {
        this.id = id;
        this.name = name;
        this.person = person;
        count++;
    }
    public Student(String name, Integer sum) {
        this.name = name;
        this.sum = sum;
    }

    public Student() {
        count++;
    }

    public Student(String name) {
        this.name = name;
        count++;
    }

    public Student(Integer id, String name, Integer courseId) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", person=" + person +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getPerson().getLastName().compareTo(o.getPerson().getLastName());
    }
}
