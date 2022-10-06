package dev.boscolo.mktoauth.controllers.exceptions;


import dev.boscolo.mktoauth.services.exceptions.IllegalArguments;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(IllegalArguments.class)
    public DtoError illegalArguments(final HttpServletRequest request, final IllegalArguments ex) {
        DtoError error = new DtoError();
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        error.setMessage("Resource Not Found");
        error.setTimestamp(Instant.now());
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return error;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public DtoError notFoundException(final HttpServletRequest request, final UsernameNotFoundException ex) {
        DtoError error = new DtoError();
        error.setError(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("Resource Not Found");
        error.setTimestamp(Instant.now());
        error.setMessage(ex.getMessage());
        error.setPath(request.getRequestURI());
        return error;
    }

}
