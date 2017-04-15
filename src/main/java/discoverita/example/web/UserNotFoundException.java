package discoverita.example.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found")
public class UserNotFoundException extends RuntimeException {
	
	
	public UserNotFoundException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public UserNotFoundException (String message) {
		super(message);
	}

}
