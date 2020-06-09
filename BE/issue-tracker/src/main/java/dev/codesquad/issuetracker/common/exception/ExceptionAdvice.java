package dev.codesquad.issuetracker.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

  @ExceptionHandler
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  private String catchInvalidTokenException(InvalidTokenException e) {
    return e.getMessage();
  }
}
