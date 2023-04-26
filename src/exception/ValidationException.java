package exception;

public class ValidationException extends Exception {
    public String getMessage(){
        return "The data is entered incorrectly";
    }
}
