package com.rohfl.imageuploder.exception;

/**
 * Created by rohfl on 06-11-2022
 **/
public class InvalidRequestException extends RuntimeException {

  String message;

  public InvalidRequestException(String message) {
    super(message);
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
