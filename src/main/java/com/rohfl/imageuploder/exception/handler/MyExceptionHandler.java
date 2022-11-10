package com.rohfl.imageuploder.exception.handler;

import com.rohfl.imageuploder.exception.InvalidRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by rohfl on 06-11-2022
 **/
@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
    Message message = new Message(500, "Internal Server Error");
    return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(InvalidRequestException.class)
  public final ResponseEntity<Object> handleInvalidRequestException(InvalidRequestException ex) {
    Message message = new Message(200, ex.getMessage());
    return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
  }
}
