package discoverita.example.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR, reason="File upload failed")
public class FileUploadException extends MultipartException {

	public FileUploadException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public FileUploadException(String msg) {
		super(msg);
	}

}
