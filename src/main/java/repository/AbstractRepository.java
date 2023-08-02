package repository;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
@Repository
@Configuration
@ComponentScan()
@PropertySource("classpath:application.properties")
public class AbstractRepository {
    @Value("${database.connectionUrl}")
    private String url;
    @Value("${database.user}")
    private String username;
    @Value("${database.password}")
    private String password;
    @Value("${database.driver}")
    private String dataBaseDriver;
    @SneakyThrows
    public Connection createConnect() {
        Class.forName(dataBaseDriver).getDeclaredConstructor().newInstance();
        return DriverManager.getConnection(url, username, password);
    }
}