package com.example.funovahue.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUploadUtil {
    public static void saveFile(String uploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path uploadPart = Paths.get(uploadDir);
        if(!Files.exists(uploadPart)){
            Files.createDirectories(uploadPart);
        }
        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadPart.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch(IOException e){
            throw new IOException("Could not save image file:"+fileName,e);
        }
    }
}