package app.library.utilities.exceptions;

public class UsernameAlreadyExist extends Exception{
    public UsernameAlreadyExist() {
    }

    public UsernameAlreadyExist(String message) {
        super(message);
    }

    public UsernameAlreadyExist(String message, Throwable cause) {
        super(message, cause);
    }
}
