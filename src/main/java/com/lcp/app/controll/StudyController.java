package com.lcp.app.controll;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lcp.app.entity.Study;
import com.lcp.app.repository.StudyRepository;


@RestController
public class StudyController {
	
	@Autowired
	StudyRepository studyRepository;
	
	@GetMapping(value = "/")
	public String holaMundo() {
		return "Hola mundo!!!!";
	}
	
	// --------------------- METODO PARA TRAER TODOS LOS ESTUDIOS----------------
	@GetMapping("/all")
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