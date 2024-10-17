package com.nguyen.cqsrWithNoPartition.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nguyen.cqsrWithNoPartition.dto.Visit;
import com.nguyen.cqsrWithNoPartition.service.VisitService;

@RestController
@RequestMapping("/visits")
public class VisitController {

    @Autowired
    private VisitService visitService;

    // Create a new visit
    @PostMapping
    public ResponseEntity<Visit> createVisit(@RequestBody Visit visit) {
        Visit createdVisit = visitService.createVisit(visit);
        return new ResponseEntity<>(createdVisit, HttpStatus.CREATED);
    }

    // Update an existing visit
    @PutMapping("/{visitID}")
    public ResponseEntity<Visit> updateVisit(@PathVariable Integer visitID, @RequestBody Visit updatedVisit) {
        Visit visit = visitService.updateVisit(visitID, updatedVisit);
        return new ResponseEntity<>(visit, HttpStatus.OK);
    }

    // Delete a visit by ID
    @DeleteMapping("/{visitID}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Integer visitID) {
        visitService.deleteVisit(visitID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a list of all visits
    @GetMapping
    public ResponseEntity<List<Visit>> getAllVisits() {
        List<Visit> visits = visitService.getAllVisits();
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

    // Get a specific visit by ID
    @GetMapping("/{visitID}")
    public ResponseEntity<Visit> getVisitById(@PathVariable Integer visitID) {
        // Call the service which will throw VisitNotFoundException if not found
        Visit visit = visitService.getVisitById(visitID);
        
        // If found, return OK with the visit data
        return ResponseEntity.ok(visit);
    }
}

