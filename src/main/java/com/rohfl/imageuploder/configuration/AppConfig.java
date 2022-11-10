package com.rohfl.imageuploder.configuration;

import com.rohfl.imageuploder.client.FileUploadClient;
import com.rohfl.imageuploder.client.FirebaseClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by rohfl on 07-11-2022
 **/
@Configuration
public class AppConfig {

  @Value("${firebase.bucket.name}")
  private String firebaseBucketName;

  @Value("${firebase.file.base.url}")
  private String firebaseFileBaseUrl;

  @Bean
  public FileUploadClient fileUploadClient() {
    return new FirebaseClient(firebaseBucketName, firebaseFileBaseUrl);
  }

  @Bean
  public ErrorProperties errorProperties() {
    return new ErrorProperties();
  }

}
