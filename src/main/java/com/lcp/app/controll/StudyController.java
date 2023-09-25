package com.lcp.app.controll;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lcp.app.entity.Study;
import com.lcp.app.repository.StudyRepository;


@RestController
@RequestMapping("api/v1/studies")
public class StudyController {
	
	@Autowired
	StudyRepository studyRepository;
	
	
	// --------------------- METODO PARA TRAER TODOS LOS ESTUDIOS----------------
	@GetMapping
	public List<Study> getAllStudies(){
		return (List<Study>) studyRepository.findAll();
	}
	
	// --------------------- METODO PARA TRAER ESTUDO POR ID ---------------------
	  @GetMapping("{studyId}")
	    public Study getStudyById(@PathVariable long studyId) {
	        Study study = studyRepository.findById(studyId).orElse(null);
	        return study;
	    }
	
	}