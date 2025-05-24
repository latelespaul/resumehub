package com.makemework.org.resume.controller;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.makemework.org.resume.service.ResumeService;
import com.makemework.org.resume.model.Resume;

import java.io.IOException;

@RestController
@RequestMapping("/api/resumes")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadResume(@RequestParam("userName") String userName, @RequestParam("file") MultipartFile file) {
        try {
            // Debug information
            System.out.println("Starting file processing...");
            System.out.println("File name: " + file.getOriginalFilename());
            System.out.println("File size: " + file.getSize());
            System.out.println("Reported content type: " + file.getContentType());

            // Extract text using Tika
            Tika tika = new Tika();
            String extractedText = tika.parseToString(file.getInputStream());

            Resume savedResume = resumeService.saveResume(userName, file, extractedText);

            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Resume uploaded and parsed successfully. Extracted " + (extractedText != null ? extractedText.length() : 0) + " characters.");

        } catch (Exception e) {
            System.err.println("Error processing file: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to process resume: " + e.getMessage());
        }
    }
}
