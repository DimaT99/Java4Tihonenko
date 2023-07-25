package entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Course implements Comparable<Course>, Serializable {
    private static int count;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

    public Course() {
        count++;
    }

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        count++;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public int compareTo(Course o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

