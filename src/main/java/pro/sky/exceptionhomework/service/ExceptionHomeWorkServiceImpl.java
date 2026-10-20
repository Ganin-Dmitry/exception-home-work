package pro.sky.exceptionhomework.service;

import org.springframework.stereotype.Service;
import pro.sky.exceptionhomework.exception.WrongLoginException;
import pro.sky.exceptionhomework.exception.WrongPasswordException;

@Service
public class ExceptionHomeWorkServiceImpl implements ExceptionHomeWorkService {
    public static String registration (String login,
                                String password,
                                String confirmPassword) {
        if (!checkFieldSimbol(login) || !checkFieldLength(login)) {
            throw new WrongLoginException("Логин введен некорректно");
        }
        if (!checkFieldSimbol(password) || !checkFieldLength(password)) {
            throw new WrongPasswordException("Пароль введен некорректно");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли отличаются");
        }
        return "";
    }

    public static boolean checkFieldSimbol (String field) {
        String simbolStr = "QqWwEeRrTtYyUuIiOoPpAaSsDdFfGgHhJjKkLlZzXxCcVvBbNnMm1234567890_";
        for (int simbol = 0; simbol < field.length(); simbol++) {
            if (simbolStr.indexOf(field.charAt(simbol)) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkFieldLength (String field) {
        if (field.length() <= 20) {
            return true;
        } else {
            return false;
        }
    }
}
