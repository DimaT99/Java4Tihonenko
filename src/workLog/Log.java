package workLog;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Log {
    private String name;
    private Enum level;
    private String message;
    LocalDateTime date;
    StackTraceElement[] stackTrace;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Enum getLevel() {
        return level;
    }

    public void setLevel(Enum level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Log(String name, Enum level, String message, LocalDateTime date, StackTraceElement[] stackTrace) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.date = date;
        this.stackTrace = stackTrace;
    }

    public Log(String name, Enum level, String message, LocalDateTime date) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", stackTrace=" + Arrays.toString(stackTrace) +
                '}';
    }
}
