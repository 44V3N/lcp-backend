package com.lcp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.lcp.app.entity.Study;
import com.lcp.app.service.StudyService;


@RestController
@RequestMapping("api/v1/studies")
public class StudyController {
	
	@Autowired
	StudyService studyService;
	
	@PostMapping
	public  ResponseEntity< Study > createStudy(@RequestBody Study study) {
		Study newStudy = studyService.createStudy(study);
		return new ResponseEntity<>(newStudy, HttpStatus.CREATED); // Status 201
	}
	
	@GetMapping("{id}")
	public ResponseEntity< Study > getStudyById(@PathVariable Long id){
		Study study = studyService.getStudyById(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	@GetMapping
	public ResponseEntity< List<Study> > getAllStudies(){
		List<Study> studies = studyService.getAllStudies();
		return new ResponseEntity<>( studies, HttpStatus.OK );
	}
	
	@GetMapping("active")
	public ResponseEntity< List<Study> > getActiveStudies(){
		List<Study> activeStudies = studyService.getActiveStudies();
		return new ResponseEntity<>( activeStudies, HttpStatus.OK );
	}
	
	@PutMapping("{id}")
	public ResponseEntity< Study > updateStudy(@PathVariable Long id,@RequestBody Study study){
		Study existingStudy = studyService.updateStudy(study, id);
		return new ResponseEntity<>(existingStudy, HttpStatus.OK); // Status 200
	}
	
	@PutMapping("disable/{id}")
	public ResponseEntity< Study > disableStudy(@PathVariable Long id){
		Study study = studyService.disableStudy(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	@PutMapping("enable/{id}")
	public ResponseEntity< Study > enableStudy(@PathVariable Long id){
		Study study = studyService.enableStudy(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	
}