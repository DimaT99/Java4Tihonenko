package exception;

import workLog.LogUtils;

public class ValidationException extends Exception {
    public String getMessage(){
        LogUtils logUtils = new LogUtils();
        logUtils.warning("The data is entered incorrectly", getStackTrace());
        return "The data is entered incorrectly";
    }
}
