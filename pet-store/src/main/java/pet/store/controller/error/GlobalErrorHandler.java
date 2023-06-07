package pet.store.controller.error;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

	@Data
	private class ExceptionMessage {
		private String message;
		private String statusReason;
		private int statusCode;
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ExceptionMessage handleNoSuchElementException(NoSuchElementException ex) {
		return buildExceptionMessage(ex, HttpStatus.NOT_FOUND);
	}

	private ExceptionMessage buildExceptionMessage(NoSuchElementException ex, HttpStatus status) {
		String message = ex.toString();
		String statusReason = status.getReasonPhrase();
		int statusCode = status.value();

		ExceptionMessage exceptionMessage = new ExceptionMessage();

		exceptionMessage.setMessage(message);
		exceptionMessage.setStatusCode(statusCode);
		exceptionMessage.setStatusReason(statusReason);

		return exceptionMessage;
	}
}
