package com.rohfl.imageuploder.service;

import com.rohfl.imageuploder.client.FileUploadClient;
import com.rohfl.imageuploder.exception.InvalidRequestException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rohfl on 06-11-2022
 **/
@Service
public class ImageService {

  @Autowired
  private FileUploadClient fileUploadClient;

  public String uploadImageAndGetUrl(MultipartFile image) throws InvalidRequestException, IOException {
    validateImageFile(image);
    return fileUploadClient.saveFile(image);
  }

  private void validateImageFile(MultipartFile file) throws InvalidRequestException {
    List<String> imageExtensions = Arrays.asList("jpg", "jpeg", "png");
    if (file == null || !imageExtensions.contains(FilenameUtils.getExtension(file.getOriginalFilename()))) {
      throw new InvalidRequestException("Please upload an image file");
    }
  }
}
