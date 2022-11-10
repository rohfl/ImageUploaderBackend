package com.rohfl.imageuploder.controller;

import static com.rohfl.imageuploder.constant.EndPointConstants.IMAGE_CONTROLLER;
import static com.rohfl.imageuploder.constant.EndPointConstants.UPLOAD;
import static org.springframework.http.ResponseEntity.ok;

import com.rohfl.imageuploder.exception.InvalidRequestException;
import com.rohfl.imageuploder.service.ImageService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rohfl on 06-11-2022
 **/
@Controller
@RequestMapping(IMAGE_CONTROLLER)
public class ImageController {

  @Autowired
  private ImageService imageService;

  @PostMapping(UPLOAD)
  ResponseEntity<String> uploadImageAndGetUrl(@RequestBody MultipartFile image)
      throws InvalidRequestException, IOException {
    return ok(imageService.uploadImageAndGetUrl(image));
  }
}
