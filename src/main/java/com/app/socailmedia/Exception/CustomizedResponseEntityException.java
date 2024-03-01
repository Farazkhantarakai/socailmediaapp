package com.app.socailmedia.Exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.app.socailmedia.UserNotFoundException;



import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request)
            throws Exception {
        ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @SuppressWarnings("null")
    protected ResponseEntity<Object> handleMethodArgumentNotValid(  MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(
                LocalDate.now().minusDays(20), "Total Errors" + ex.getErrorCount() + "First Error" + ex.getFieldError().getDefaultMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }




    
    // URI
    // location=ServeletUriComponentBuilder.fromRequest().path('${id}').expandAndBuild(user.getId()).toUri();
    // ResponseEntity.created(location).build();
    // 200 ok
    // 201 no Content
    // 401 unauthorized accessed
    // 400 bad request
    // 500 server error

}


// enum Status{
//     loading,
//     loaded,
//     error
// }