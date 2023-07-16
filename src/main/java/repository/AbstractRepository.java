package repository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
@Component
public class AbstractRepository {
    @Value("${database.connectionUrl}")
    private static String url;
    @Value("${database.user}")
    private static String username;
    @Value("${database.password}")
    private static String password;
    @Value("${database.driver}")
    private static String dataBaseDriver;
    @SneakyThrows
    public static Connection createConnect() {
        Class.forName(dataBaseDriver).getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(url, username, password);
    }
}