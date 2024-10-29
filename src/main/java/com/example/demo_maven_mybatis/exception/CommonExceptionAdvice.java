package com.example.demo_maven_mybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

//import lombok.extern.slf4j.Slf4j;
import lombok.extern.log4j.Log4j;

//@Slf4j
@Log4j
@ControllerAdvice
public class CommonExceptionAdvice {
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle404(NoHandlerFoundException exception) {
        return "error/custom404";
    }

    @ExceptionHandler(Exception.class)
    public String except(Exception exception, Model model) {
        System.out.println("Exception ......." + exception.getMessage());
        model.addAttribute("exception", exception);
        System.out.println(model);

        log.trace("This is a TRACE level message");
        log.debug("This is a DEBUG level message");
        log.info("This is an INFO level message");
        log.warn("This is a WARN level message");
        log.error("This is an ERROR level message");

        return "error/error_page";
    }

    /* 500은 잡히지 않고 오히려 엉뚱한 오류가 잡혀서 주석 처리
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handle500(Exception exception, Model model) {
        model.addAttribute("exception", exception);
        return "error/custom500";  // 500 오류 페이지로 리턴
    }
    */
}
