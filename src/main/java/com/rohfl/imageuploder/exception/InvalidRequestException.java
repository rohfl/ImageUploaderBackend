package com.rohfl.imageuploder.exception;

import javax.xml.bind.ValidationException;

/**
 * Created by rohfl on 06-11-2022
 **/
public class InvalidRequestException extends ValidationException {

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
