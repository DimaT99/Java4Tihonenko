package repository;

import entity.Course;
import entity.Lecture;
import entity.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PostgreSqlRepo extends AbstractRepository {
    public static List<Lecture> getAllLecture() {
        try {
            final String sql = "SELECT * FROM lecture";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
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
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
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
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
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

    public static void insertColumns() {
        try {
            String insertQuery = "INSERT INTO public.homework( id, task, lecture_id) VALUES (?, ?, ?);";

            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                conn.setAutoCommit(false);

                preparedStatement.setInt(1, (int) (Math.random() * 100));
                preparedStatement.setString(2, "Homework2");
                preparedStatement.setInt(3, 1);
                preparedStatement.addBatch();

                preparedStatement.setInt(1, (int) (Math.random() * 100));
                preparedStatement.setString(2, "Homework3");
                preparedStatement.setInt(3, 3);
                preparedStatement.addBatch();

                int[] result = preparedStatement.executeBatch();

                conn.commit();

                System.out.println("add Lines Device: " + result);
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
    }
}
