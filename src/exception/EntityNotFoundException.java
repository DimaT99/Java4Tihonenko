package exception;

public class EntityNotFoundException extends Exception {
    public String getMessage(){
        return "ID is missing";
    }
}
