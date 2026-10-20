package pro.sky.exceptionhomework.service;

import org.springframework.stereotype.Service;
import pro.sky.exceptionhomework.exception.WrongLoginException;
import pro.sky.exceptionhomework.exception.WrongPasswordException;

@Service
public class ExceptionHomeWorkServiceImpl implements ExceptionHomeWorkService {
    public String registration (String login,
                                String password,
                                String confirmPassword) {
        if (!checkFieldSimbol(login) || login.length() > 20) {
            throw new WrongLoginException("Логин введен некорректно");
        }
        if (!checkFieldSimbol(password) || password.length() > 20) {
            throw new WrongPasswordException("Пароль введен некорректно");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли отличаются");
        }
        return "";
    }

    public boolean checkFieldSimbol (String field) {
        String simbolStr = "QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm1234567890_";
        for (int simbol = 0; simbol < field.length(); simbol++) {
            if (simbolStr.indexOf(field.charAt(simbol)) == -1) {
                return false;
            }
        }
        return true;
    }
}
