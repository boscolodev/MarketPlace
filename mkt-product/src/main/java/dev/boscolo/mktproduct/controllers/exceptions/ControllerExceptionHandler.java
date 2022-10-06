package dev.boscolo.mktproduct.controllers.exceptions;


import dev.boscolo.mktproduct.services.exceptions.DatabaseException;
import dev.boscolo.mktproduct.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public DtoError notFoundException(final HttpServletRequest request, final ResourceNotFoundException ex) {
        DtoError error = new DtoError();
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("Resource Not Found");
        error.setTimestamp(Instant.now());
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return error;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DatabaseException.class)
    public DtoError databaseException(final HttpServletRequest request, final DatabaseException ex) {
        DtoError error = new DtoError();
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Email already exists!");
        error.setTimestamp(Instant.now());
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return error;
    }

}
