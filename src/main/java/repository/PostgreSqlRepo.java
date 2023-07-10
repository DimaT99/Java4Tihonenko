package repository;

import entity.*;

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

    public static List<Student> sort() {
        try {
            final String sql = "SELECT * FROM students ORDER BY last_name";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Student> studentList = new ArrayList<>();
                while (resultSet.next()) {
                    Student student = new Student(resultSet.getInt("id"),
                            (resultSet.getString("first_name") + " " + resultSet.getString("last_name")),
                            resultSet.getInt("course_id"));
                    studentList.add(student);
                }
                return studentList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Lecture> sort1() {
        try {
            final String sql = "SELECT name, number_of_additional FROM lecture WHERE lecture_date < '2023-01-01' ORDER BY lecture_date;";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Lecture> lectureList = new ArrayList<>();
                while (resultSet.next()) {
                    Lecture lecture = new Lecture(resultSet.getString("name"),
                            resultSet.getInt("number_of_additional"));
                    lectureList.add(lecture);
                }
                return lectureList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Lecture> sort2() {
        try {
            final String sql = "SELECT * FROM lecture ORDER BY lecture_date, number_of_hw DESC LIMIT 1;";
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

    public static List<Additional> sort3() {
        try {
            final String sql = "SELECT resource_type, COUNT (resource_type) FROM additionals GROUP BY resource_type;";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Additional> additionalList = new ArrayList<>();
                while (resultSet.next()) {
                    Additional additional = new Additional(resultSet.getString("resource_type"),
                            resultSet.getInt("count"));
                    additionalList.add(additional);
                }
                return additionalList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Teacher> sort4() {
        try {
            final String sql = "SELECT * FROM teacher WHERE (last_name >= 'A' AND last_name < 'N') OR (last_name >= 'А' AND last_name < 'Н');";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Teacher> teacherList = new ArrayList<>();
                while (resultSet.next()) {
                    Teacher teacher = new Teacher(resultSet.getInt("id"),
                            (resultSet.getString("first_name") + " " + resultSet.getString("last_name")));
                    teacherList.add(teacher);
                }
                return teacherList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }

    public static List<Student> sort5() {
        try {
            final String sql = "SELECT first_name, last_name, COUNT (course_id)\n" +
                    "FROM students\n" +
                    "GROUP BY first_name, last_name\n" +
                    "ORDER BY last_name;";
            try (Connection conn = createConnect();
                 PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                final ResultSet resultSet = preparedStatement.executeQuery();
                final List<Student> studentList = new ArrayList<>();
                while (resultSet.next()) {
                    Student student = new Student((resultSet.getString("first_name") + " " + resultSet.getString("last_name")),
                    resultSet.getInt("count"));
                    studentList.add(student);
                }
                return studentList;
            }
        } catch (Exception ex) {
            System.out.println("Connection failed..." + ex);
        }
        throw new IllegalArgumentException();
    }
}