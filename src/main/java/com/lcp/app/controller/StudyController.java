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
	
	@CrossOrigin(origins = "*")
	@PostMapping
	public  ResponseEntity< Study > createStudy(@RequestBody Study study) {
		Study newStudy = studyService.createStudy(study);
		return new ResponseEntity<>(newStudy, HttpStatus.CREATED); // Status 201
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("{id}")
	public ResponseEntity< Study > getStudyById(@PathVariable Long id){
		Study study = studyService.getStudyById(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping
	public ResponseEntity< List<Study> > getAllStudies(){
		List<Study> studies = studyService.getAllStudies();
		return new ResponseEntity<>( studies, HttpStatus.OK );
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/active")
	public ResponseEntity< List<Study> > getActiveStudies(){
		List<Study> activeStudies = studyService.getActiveStudies();
		return new ResponseEntity<>( activeStudies, HttpStatus.OK );
	}
	
	@CrossOrigin(origins = "*")
	@PutMapping("{id}")
	public ResponseEntity< Study > updateStudy(@PathVariable Long id,@RequestBody Study study){
		Study existingStudy = studyService.updateStudy(study, id);
		return new ResponseEntity<>(existingStudy, HttpStatus.OK); // Status 200
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("{id}")
	public ResponseEntity< Study > deleteStudy(@PathVariable Long id){
		Study study = studyService.deleteStudy(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	
}