package com.rohfl.imageuploder.client;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by rohfl on 07-11-2022
 **/
public interface FileUploadClient {

  String saveFile(MultipartFile file) throws IOException;
}
