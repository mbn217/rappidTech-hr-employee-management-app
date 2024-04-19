package org.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.model.response.BaseResponse;
import org.example.model.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.List;


@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {


    // this exception handler is the "catch-all" handler for Exceptions. Any exception that just logs the exception
    // and returns an INTERNAL_SERVER_ERROR with the exception message should just use this method instead of
    // creating another handler.
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<BaseResponse<Void>> internalServerErrorHandler(Exception e, WebRequest request) {
        logException(e);
        return ResponseHandler.generateResponse(null, e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<BaseResponse<Void>> invalidArgumentErrorHandler(MethodArgumentNotValidException e, WebRequest request) {

        // get default message
        String defaultMessage = e.getAllErrors().get(0).getDefaultMessage();

        // loop through all errors on exception to get all error messages
        StringBuilder allErrorMessages = new StringBuilder();
        BindingResult bindingResult = e.getBindingResult();
        if(bindingResult!=null && bindingResult.hasErrors()){

            List<ObjectError> errors = bindingResult.getAllErrors();
            for(int i = 0; i < errors.size(); i++){

                ObjectError error = errors.get(i);
                String errorMessage = error.getDefaultMessage();
                allErrorMessages.append(errorMessage);

                if(i < errors.size() - 1){
                    allErrorMessages.append("\n");
                }
            }

        }

        // finalize response message, then log and return it.
        String responseMessage = StringUtils.isBlank(allErrorMessages) ? defaultMessage : allErrorMessages.toString();
        log.debug("Invalid request: {}", responseMessage);
        return ResponseHandler.generateResponse(null, responseMessage, HttpStatus.BAD_REQUEST);
    }

    private void logException(Exception e) {
        log.error("Caught Controller-level Exception.", e);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceEntityNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),ex.getMessage(), request.getDescription(false) );
        return new ResponseEntity<>(errorDetails,  HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DbTableNotFoundException.class)
    public ResponseEntity<Object> dbTableNotFoundException(DbTableNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> validationException(ConstraintViolationException ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getLocalizedMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
