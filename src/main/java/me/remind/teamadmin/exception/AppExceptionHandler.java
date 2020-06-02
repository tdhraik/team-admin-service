package me.remind.teamadmin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public final ResponseEntity<AppErrorResponse> handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(constructAppErrorResponse(ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalStateException.class)
    public final ResponseEntity<AppErrorResponse> handleIllegalStateException(IllegalStateException ex) {
        return new ResponseEntity<>(constructAppErrorResponse(ex), HttpStatus.BAD_REQUEST);
    }

    @Override
    public final ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        //// TODO: 02/06/20 can do better !!
        return new ResponseEntity<>(new AppErrorResponse("Validation errors",
                "Please check the validation errors below", Instant.now(), errors), HttpStatus.BAD_REQUEST);
    }

    private AppErrorResponse constructAppErrorResponse(RuntimeException ex) {
        return new AppErrorResponse(ex.getMessage(), ex.getLocalizedMessage(), Instant.now(), null);
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private class AppErrorResponse {
        private String message;
        private String details;
        private Instant timestamp;
        Map<String, String> validationErrors;
    }
}
