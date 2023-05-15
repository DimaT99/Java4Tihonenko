package workLog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogUtils {
    private static List<Log> logList = new ArrayList<>();
    public static Class<?> className;

    public static List<Log> getLogList() {
        return logList;
    }

    public void saveLog(Log log) {
        logList.add(log);
    }

    public void error(String message, StackTraceElement[] stackTrace) {
        Log log = new Log(className.getName(), EnumLogLevel.ERROR, message, LocalDateTime.now(), stackTrace);
        saveLog(log);
    }

    public void warning(String message, StackTraceElement[] stackTrace) {
        Log log = new Log(className.getName(), EnumLogLevel.WARNING, message, LocalDateTime.now(), stackTrace);
        saveLog(log);
    }
    public void info(String message) {
        Log log = new Log(className.getName(), EnumLogLevel.INFO, message, LocalDateTime.now());
        saveLog(log);
    }

    public void debug(String message) {
        Log log = new Log(className.getName(), EnumLogLevel.DEBUG, message, LocalDateTime.now());
        saveLog(log);
    }
}
