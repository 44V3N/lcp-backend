package com.lcp.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcp.app.entity.Study;
import com.lcp.app.repository.StudyRepository;
import com.lcp.app.service.StudyService;

@Service
public class StudyServiceImpl implements StudyService{

	@Autowired
	StudyRepository studyRepository;
	
	@Override
	public Study createStudy(Study study) {
		return saveStudy(study);
	
	}
	
	public Study saveStudy(Study study) {
		return studyRepository.save(study);
	}

	@Override
	public Study getStudyById(Long id) {
		return studyRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Study does not exist with id " + id) );
	}
	
    public List <Study> getActiveStudies() {
        List <Study> activeStudies = studyRepository.findByIsActive(true);
              if( activeStudies == null || activeStudies.isEmpty()) {
                 throw new IllegalStateException("No active studies found");
              }
              return activeStudies;
     }

	@Override
	public List<Study> getAllStudies() {
		return (List<Study>) studyRepository.findAll();
	}

	@Override
	public Study updateStudy(Study study, Long id) {
		Study existingStudy = getStudyById(id);
		existingStudy.setName(  study.getName()   );
		existingStudy.setIndications(  study.getIndications()   );
		existingStudy.setWaitTime(  study.getWaitTime()   );
		return saveStudy( existingStudy );
	}

	@Override
	public Study deleteStudy(Long id) {
		Study existingStudy = getStudyById(id);
		studyRepository.delete(existingStudy);
		return existingStudy;
	}

}
