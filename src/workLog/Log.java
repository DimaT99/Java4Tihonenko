package workLog;

import java.util.Arrays;

public class Log {
    private String name;
    private Enum level;
    private String message;
    private String dateLog;
    StackTraceElement[] stackTrace;

    public String getDateLog() {
        return dateLog;
    }

    public void setDateLog(String dateLog) {
        this.dateLog = dateLog;
    }

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

    public Log(String name, Enum level, String message, String dateLog, StackTraceElement[] stackTrace) {
        this.name = name  + " ";
        this.level = level;
        this.message = message  + " ";
        this.dateLog = dateLog;
        this.stackTrace = stackTrace;
    }

    public Log(String name, Enum level, String message, String dateLog) {
        this.name = name + " ";
        this.level = level;
        this.message = message  + " ";
        this.dateLog = dateLog;
    }

    @Override
    public String toString() {
        return "Log{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", message='" + message + '\'' +
                ", dateLog=" + dateLog +
                ", stackTrace=" + Arrays.toString(stackTrace) +
                '}';
    }
}
