package repository;

import entity.Course;
import entity.Lecture;
import entity.Teacher;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlRepo extends AbstractRepository {
    public static List<Lecture> getAllLecture() {
        try {
            final String sql = "SELECT * FROM lecture";
            try (Connection conn = createConnect();
                 Statement statement = conn.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(sql);
                final List<Lecture> lectureList = new ArrayList<>();
                while (resultSet.next()) {
                    Lecture lecture = new Lecture(resultSet.getInt("course_id"),
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getString("lecture_date"));
                    lectureList.add(lecture);
                }
                return lectureList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Course> getAllCourse() {
        try {
            final String sql = "SELECT * FROM course";
            try (Connection conn = createConnect();
                 Statement statement = conn.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(sql);
                final List<Course> courseList = new ArrayList<>();
                while (resultSet.next()) {
                    Course course = new Course(resultSet.getInt("id"),
                            resultSet.getString("name"));
                    courseList.add(course);
                }
                return courseList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Teacher> getAllTeacher() {
        try {
            final String sql = "SELECT * FROM teacher";
            try (Connection conn = createConnect();
                 Statement statement = conn.createStatement()) {
                final ResultSet resultSet = statement.executeQuery(sql);
                final List<Teacher> courseList = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher(resultSet.getInt("id"),
                            (resultSet.getString("first_name") + " " + resultSet.getString("last_name")));
                    courseList.add(teacher);
                }
                return courseList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }
}
