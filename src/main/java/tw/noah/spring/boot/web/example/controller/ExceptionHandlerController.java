package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import tw.noah.spring.boot.web.example.exception.MyRuntimeException;

/**
 * global error handler , on web project , 404 default on /error/404.jsp
 * @Controller is require.
 */
@Log4j2
@Controller
public class ExceptionHandlerController {

  @ControllerAdvice
  class GeneralErrorException {
    /**
     * INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(value = { Exception.class ,MyRuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final String handleInternalServerError(Exception ex) {
      log.error(ex,ex);
      return "error/500";
    }


  }

}