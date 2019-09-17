package excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Company Not Found")
	@ExceptionHandler(CompanyNotFoundException.class)
	public void CompanyNotFound(){
		
	}
	
	
}
