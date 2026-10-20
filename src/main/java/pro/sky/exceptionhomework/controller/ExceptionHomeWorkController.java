package pro.sky.exceptionhomework.controller;

import org.springframework.web.bind.annotation.RestController;
import pro.sky.exceptionhomework.service.ExceptionHomeWorkService;

@RestController
public class ExceptionHomeWorkController {

    private final ExceptionHomeWorkService exceptionHomeWorkService;
    public ExceptionHomeWorkController (ExceptionHomeWorkService exceptionHomeWorkService) {
        this.exceptionHomeWorkService = exceptionHomeWorkService;
    }
}
