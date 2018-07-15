package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import tw.noah.spring.boot.web.example.exception.MyRuntimeException;

/**
 * global error handler
 * @Controller is require.
 */
@Log4j2
@Controller
public class ExceptionHandlerController {


  // internal 500 exception
  @ControllerAdvice
  class GeneralErrorException {

    /**
     * BAD_REQUEST
     */
    @ExceptionHandler(value = {ServletRequestBindingException.class,MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public final String handleBadRequest(Exception ex) {
      log.error(ex);
      return "error-pages/500";
    }

    /**
     * INTERNAL_SERVER_ERROR
     */
    @ExceptionHandler(value = { Exception.class ,MyRuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final String handleInternalServerError(Exception ex) {
      log.error(ex,ex);
      return "error-pages/500";
    }

    /**
     * spring 404 NOT_FOUND exception
     */
    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final String handleNotFoundException(WebRequest request, Exception ex) {
//      request.get
      log.error(request.getContextPath());
//      log.error(request.getRequestURL());
      log.error(ex,ex);
      return "error-pages/404";
    }

  }

// spring boot web default 404 on /error ，透過覆寫 /error 來達到處理 404 ，但容易跟真實情境需用 /error 時衝突
// 故改用 NoHandlerFoundException.class 處理
//  // default - 404 not found.
//  @Controller
//  class NotFoundException implements ErrorController {
//    private static final String PATH = "/error";
//
//    @RequestMapping(value = PATH)
//    public String error() {
//      return "error/404";
//    }
//
//    @Override
//    public String getErrorPath() {
//      return PATH;
//    }
//  }
}