package kodlamaio.notrhwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import kodlamaio.notrhwind.business.abstracts.UserService;
import kodlamaio.notrhwind.core.Utilities.result.ErrorDataResult;
import kodlamaio.notrhwind.core.Utilities.result.Result;
import kodlamaio.notrhwind.core.entities.User;

@RestController //java olmayanlarda bizi tanısın
@RequestMapping("/api/users") //sub domain i verdik.
public class UsersController {
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	//valid demek validasyondan gecir demek.
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(userService.add(user));
	}
		
	//tum herşeyin tipi objectir. Sistemde bir hata oluşursa calış dedik.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		//dictinory oluşturduk key value
		Map<String,String> validationErrors = new HashMap<String, String>();
		//tum hataları aldık. dongu ile put yaptık.
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		//error data result ın icine koy ve bu hataları dondur dedik.
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors;
	}
}
