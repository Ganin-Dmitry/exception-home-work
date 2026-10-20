package pro.sky.exceptionhomework.service;

public interface ExceptionHomeWorkService {
    public String registration (String login,
                                String password,
                                String confirmPassword);
    public boolean checkFieldSimbol (String field);
}
