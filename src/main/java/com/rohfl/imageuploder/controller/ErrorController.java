package com.rohfl.imageuploder.controller;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.NestedServletException;

/**
 * Created by rohfl on 10-11-2022
 **/
@Controller
public class ErrorController extends BasicErrorController {

  public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
    super(errorAttributes, errorProperties);
  }

  @RequestMapping
  public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
    Exception ex = (Exception) request.getAttribute("javax.servlet.error.exception");
    if(ex instanceof NestedServletException && ex.getCause() instanceof RuntimeException) {
      throw (RuntimeException) ex.getCause();
    }
    return super.error(request);
  }
}
