package excpetions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Company Not Found")
public class CompanyNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public CompanyNotFoundException(int id) {
		super("Company with the id" + id + "was not found!");
	}
	

}
