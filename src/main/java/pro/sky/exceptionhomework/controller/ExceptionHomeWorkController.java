package pro.sky.exceptionhomework.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.exceptionhomework.exception.WrongLoginException;
import pro.sky.exceptionhomework.exception.WrongPasswordException;
import pro.sky.exceptionhomework.service.ExceptionHomeWorkService;

@RestController
@RequestMapping(path = "/account")
public class ExceptionHomeWorkController {
    private final ExceptionHomeWorkService exceptionHomeWorkService;
    public ExceptionHomeWorkController (ExceptionHomeWorkService exceptionHomeWorkService) {
        this.exceptionHomeWorkService = exceptionHomeWorkService;
    }

    @GetMapping
    public String startView () {
        return "<b>Добро пожаловать на стартовую страницу!<br>" +
                "Допустимые символы для логина и пароля:</b><br>" +
                "Латинские буквы;<br>" +
                "Цифры;<br>" +
                "Нижнее подчеркивание.<br>" +
                "<b>Максимальная длина логина/пароля 20 символов.</b>";
    }

    @GetMapping(path = "/registration")
    public String registration (@RequestParam (name = "login", required = false) String login,
                                @RequestParam (name = "password", required = false) String password,
                                @RequestParam (name = "confirmPassword", required = false) String confirmPassword) {
        try{
            return exceptionHomeWorkService.registration(login, password, confirmPassword);
        } catch (WrongLoginException e) {
            return "Логин введен некорректно";
        } catch (WrongPasswordException e) {
            return "Пароль введен некорректно";
        } catch (NullPointerException e) {
            return "Одно из полей не введено";
        }
    }
}
