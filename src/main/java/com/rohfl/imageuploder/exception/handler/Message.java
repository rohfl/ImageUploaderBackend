package com.rohfl.imageuploder.exception.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Created by rohfl on 06-11-2022
 **/
@Getter
@ApiModel(value = "error_message", description = "Error message when there is a failure to process the request")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@ToString
public class Message {

  @ApiModelProperty(name = "code", value = "Error code defining the type of error")
  private int code;

  @ApiModelProperty(name = "message", value = "An error message containing the reason for the failure",
      required = true)
  private String message;

  public Message(int code, String message) {
    this.code = code;
    this.message = message;
  }
}
