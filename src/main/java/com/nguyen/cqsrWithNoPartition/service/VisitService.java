package com.nguyen.cqsrWithNoPartition.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyen.cqsrWithNoPartition.aspect.VisitNotFoundException;
import com.nguyen.cqsrWithNoPartition.dto.Visit;
import com.nguyen.cqsrWithNoPartition.repo.VisitRepository;

@Service
public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    

    // Create a new visit
    public Visit createVisit(Visit visit) {
        return visitRepository.save(visit);
    }

    // Update an existing visit
    @Transactional
    public Visit updateVisit(Integer visitID, Visit updatedVisit) {
        Optional<Visit> existingVisit = visitRepository.findById(visitID);
        if (existingVisit.isPresent()) {
            Visit visit = existingVisit.get();
            visit.setVisitDate(updatedVisit.getVisitDate());
            visit.setPatient(updatedVisit.getPatient()); // Optional: update patient if needed
            return visitRepository.save(visit);
        } else {
            throw new VisitNotFoundException("Visit not found with ID: " + visitID);
        }
    }

    // Delete a visit by ID
    @Transactional
    public void deleteVisit(Integer visitID) {
        visitRepository.deleteById(visitID);
    }

    // Retrieve a list of all visits
    public List<Visit> getAllVisits() {
        return visitRepository.findAll();
    }

    // Retrieve a specific visit by ID
    public Visit getVisitById(Integer visitID) {
        return visitRepository.findById(visitID)
                .orElseThrow(() -> new VisitNotFoundException("Visit not found with ID: " + visitID));
    }
}

