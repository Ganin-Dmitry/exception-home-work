package pro.sky.exceptionhomework.exception;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException (String explanation) {
        super(explanation);
    }
}
