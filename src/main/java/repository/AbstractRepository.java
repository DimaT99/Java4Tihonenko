package repository;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractRepository {
    @SneakyThrows
    public static Connection createConnect() {
        final String url = "jdbc:postgresql://localhost:5432/school_online";
        final String username = "postgres";
        final String password = "210994";
        Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(url, username, password);
    }
}