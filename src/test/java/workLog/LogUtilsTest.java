package workLog;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LogUtilsTest {

    static LogUtils target;
    ArrayList<Log> logList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        target = new LogUtils();
        System.out.println("BeforeEach passed");
    }

    @AfterEach
    void afterResult() {
        System.out.println("AfterEach passed");
    }

    @BeforeAll
    static void setAll() {
        System.out.println("BeforeAll passed");
    }

    @AfterAll
    static void setAllAfter() {
        System.out.println("AfterAll passed");
    }

    @Test
    void getLogTest() {
        ArrayList<Log> logArr = new ArrayList<>();
        assertThat(logArr)
                .isEqualTo(logList);
    }

    @Test
    void isNullLogTest() {
        assertThrows(IllegalArgumentException.class,
                () -> target.saveLog(null));
    }

    @Test
    void isListDataTest() {
        Log log;
        for (int i = 1; i < 3; i++) {
            log = new Log("Log" + i, EnumLogLevel.INFO,
                    "test" + i, null);
            logList.add(log);

            //LogUtils.getLogList().add(log);
        }
        assertThat(logList)
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(LogUtils.getLogList());
    }
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