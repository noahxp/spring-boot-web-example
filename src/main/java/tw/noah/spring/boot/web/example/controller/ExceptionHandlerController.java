package tw.noah.spring.boot.web.example.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import tw.noah.spring.boot.web.example.exception.DataNotFoundException;
import tw.noah.spring.boot.web.example.exception.MyRuntimeException;

/**
 * global error handler
 * 
 */
@Log4j2
public class ExceptionHandlerController {
  // if environment eq "dev" or "staging" , get detail exception.
//	@Value("${debug_mode}")
//	private boolean debugMode;


	// internal 500 exception
	@ControllerAdvice
	class GeneralErrorException {

		/**
		 * BAD_REQUEST
		 * @param ex
		 * @return
		 */
		@ExceptionHandler(value = {ServletRequestBindingException.class,MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
		public final String handleBadRequest(Exception ex) {
		  log.error(ex,ex);
			return "error/500";
		}

    /**
     * INTERNAL_SERVER_ERROR
     * @param ex
     * @return
     */
    @ExceptionHandler(value = { Exception.class,MyRuntimeException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final String handleInternalServerError(Exception ex) {
      log.error(ex,ex);
      return "error/500";
    }

	}


	// default - 404 not found.
  @Controller
	class NotFoundException implements ErrorController {
		private static final String PATH = "/error";

		@RequestMapping(value = PATH)
    @ResponseStatus(HttpStatus.NOT_FOUND)
		public String error() {
		  log.info( "404 [" + PATH + "]");
		  return "error/404";
		}

		@Override
		public String getErrorPath() {
			return PATH;
		}
	}
}
