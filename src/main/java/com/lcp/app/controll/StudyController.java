package com.lcp.app.controll;

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
	
	@PutMapping("{id}")
	public ResponseEntity< Study > updateStudy(@PathVariable Long id,@RequestBody Study study){
		Study existingStudy = studyService.updateStudy(study, id);
		return new ResponseEntity<>(existingStudy, HttpStatus.OK); // Status 200
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity< Study > deleteStudy(@PathVariable Long id){
		Study study = studyService.deleteStudy(id);
		return new ResponseEntity<>(study, HttpStatus.OK); // Status 200
	}
	
	
}