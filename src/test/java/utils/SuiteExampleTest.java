package utils;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages({"workLog"})
@IncludeTags("RUN")
@ExcludeTags("SKIP")
@SuiteDisplayName("A demo Test Suite")

public class SuiteExampleTest {
}
