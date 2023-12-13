package whlsteq.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import whlsteq.backend.core.utilities.BusinessException;
import whlsteq.backend.core.utilities.ProblemDetails;
import whlsteq.backend.core.utilities.ValidationProblemDetails;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
public class WhlsteqBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhlsteqBackendApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException){
		ProblemDetails problemDetails=new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(MethodArgumentNotValidException methodArgumentNotValidException){
		ValidationProblemDetails validationProblemDetails=new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation.exception");
		validationProblemDetails.setValidationErrors(new HashMap<String , String>());

		for (FieldError fieldError:
				methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(),fieldError.getDefaultMessage());

		}
		return validationProblemDetails;
	}




	@Bean
	public ModelMapper getModelMapper(){
		return new ModelMapper();
	}

}
