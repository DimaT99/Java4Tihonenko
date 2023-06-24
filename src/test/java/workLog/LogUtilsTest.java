package workLog;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LogUtilsTest {

    static LogUtils target;
    ArrayList<Log> logList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        target = new LogUtils();
    }

    @AfterEach
    void afterResult() {
        LogUtils.getLogList().clear();
    }
    @Tag("RUN")
    @Test
    void getLogTest() {
        ArrayList<Log> logArr = new ArrayList<>();
        assertThat(logArr)
                .isEqualTo(logList);
    }
    @Tag("RUN")
    @Test
    void isNullLogTest() {
        assertThrows(IllegalArgumentException.class,
                () -> target.saveLog(null));
    }
    @Tag("RUN")
    @Test
    void isListDataTest() {
        Log log;
        for (int i = 1; i < 3; i++) {
            log = new Log("Log" + i, EnumLogLevel.INFO,
                    "test" + i, null);
            logList.add(log);

            LogUtils.getLogList().add(log);
        }
        assertThat(logList)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(LogUtils.getLogList());
    }
    @Tag("SKIP")
    @Test
    void isListLogTest() {
        Log log;
        for (int i = 1; i < 3; i++) {
            log = new Log("Log" + i, EnumLogLevel.INFO,
                    "test" + i, null);
            logList.add(log);

            LogUtils.getLogList().add(log);
        }
        assertThat(logList)
                .hasSize(LogUtils.getLogList().size());
    }
}