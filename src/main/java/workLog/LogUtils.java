package workLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogUtils {
    private static List<Log> logList = new ArrayList<>();
    public static Class<?> className;

    public static List<Log> getLogList() {
        return logList;
    }
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    public void saveLog(Log log) {
        if(className == null){
            throw new IllegalArgumentException();
        }
        logList.add(log);
    }

    public void error(String message, StackTraceElement[] stackTrace) {
        Log log = new Log(className.getName(),EnumLogLevel.ERROR, message, LocalDateTime.now().format(formatter), stackTrace);
        saveLog(log);
    }

    public void warning(String message, StackTraceElement[] stackTrace) {
        Log log = new Log(className.getName(), EnumLogLevel.WARNING, message, LocalDateTime.now().format(formatter), stackTrace);
        saveLog(log);
    }
    public void info(String message) {
        Log log = new Log(className.getName(), EnumLogLevel.INFO, message, LocalDateTime.now().format(formatter));
        saveLog(log);
    }
    public void info(String message, String creationDate) {
        Log log = new Log(className.getName(), EnumLogLevel.INFO, message, creationDate);
        saveLog(log);
    }

    public void debug(String message) {
        Log log = new Log(className.getName(), EnumLogLevel.DEBUG, message, LocalDateTime.now().format(formatter));
        saveLog(log);
    }
}
