package com.lcp.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lcp.app.entity.Study;

public interface StudyRepository extends JpaRepository< Study, Long>{
}