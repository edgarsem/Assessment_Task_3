package lt.viko.eif.esemasko.Assessment_Task_3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Controller advice class that handles exceptions of type {@link MovieNotFoundException}.
 */
@ControllerAdvice
class MovieNotFoundAdvice {

	/**
	 * Exception handler method for {@link MovieNotFoundException}.
	 *
	 * @param ex the exception instance
	 * @return the exception message
	 */
	@ResponseBody
	@ExceptionHandler(MovieNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String employeeNotFoundHandler(MovieNotFoundException ex) {
		return ex.getMessage();
	}
}
