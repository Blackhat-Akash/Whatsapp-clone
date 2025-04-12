package com.whatsapp.Whatsapp_clone.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class FileUtils {

    private FileUtils() {
        // Prevent instantiation
    }

    public static byte[] readFileFromLocation(String fileUrl) {
        if (!StringUtils.hasText(fileUrl)) {
            return new byte[0];
        }

        try {
            Path filePath = new File(fileUrl).toPath();
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            log.warn("No file found at the path: {}", fileUrl, e);
        }

        return new byte[0];
    }
}
