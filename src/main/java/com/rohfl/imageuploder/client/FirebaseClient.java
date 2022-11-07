package com.rohfl.imageuploder.client;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rohfl on 07-11-2022
 **/
@Slf4j
public class FirebaseClient implements FileUploadClient {

  private String bucketName, fileBaseUrl;

  private final String DOT = ".";

  public FirebaseClient(String bucketName, String fileBaseUrl) {
    this.bucketName = bucketName;
    this.fileBaseUrl = fileBaseUrl;
    try {
      ClassPathResource account = new ClassPathResource("gservices.json");
      FirebaseOptions options =
          new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(account.getInputStream()))
              .setStorageBucket(this.bucketName).build();
      FirebaseApp.initializeApp(options);
    } catch (Exception e) {
      log.error("Exception in creating Firebase Client", e);
    }
  }

  @Override
  public String saveFile(MultipartFile file) throws IOException {
    Bucket bucket = StorageClient.getInstance().bucket();
    String fileName = generateFileName(file.getOriginalFilename());
    bucket.create(fileName, file.getBytes(), file.getContentType());
    return getFileUrl(fileName);
  }

  private String getFileUrl(String fileName) {
    return String.format(fileBaseUrl, fileName);
  }

  private String generateFileName(String fileName) {
    return System.currentTimeMillis() + DOT + FilenameUtils.getExtension(fileName);
  }
}
