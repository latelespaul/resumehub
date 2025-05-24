package com.makemework.org.resume.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.makemework.org.resume.model.Resume;
import com.makemework.org.resume.repository.ResumeRepository;

import java.io.IOException;

@Service
public class ResumeService {
    
    private final ResumeRepository resumeRepository;
    
    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }
    
    public Resume saveResume(String userName, MultipartFile file, String extractedText) throws IOException {
        Resume resume = new Resume();
        resume.setFileName(file.getOriginalFilename());
        resume.setContentType(file.getContentType());
        resume.setFileData(file.getBytes());
        resume.setExtractedText(extractedText);
        resume.setFileSize(file.getSize());
        resume.setUserName(userName);
        
        return resumeRepository.save(resume);
    }
}
