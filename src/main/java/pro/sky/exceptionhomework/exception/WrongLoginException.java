package pro.sky.exceptionhomework.exception;

public class WrongLoginException extends RuntimeException{
    public WrongLoginException (String explanation) {
        super(explanation);
    }
}
