package com.makemework.org.resume.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.makemework.org.resume.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
