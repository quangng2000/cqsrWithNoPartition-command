package com.nguyen.cqsrWithNoPartition.controller;



import java.util.List;
import java.util.Optional;

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

import com.nguyen.cqsrWithNoPartition.dto.Patient;
import com.nguyen.cqsrWithNoPartition.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Create a new patient
    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    // Update an existing patient
    @PutMapping("/{patientID}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Integer patientID, @RequestBody Patient updatedPatient) {
        Patient patient = patientService.updatePatient(patientID, updatedPatient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    // Delete a patient by ID
    @DeleteMapping("/{patientID}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer patientID) {
        patientService.deletePatient(patientID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get a list of all patients
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    // Get a specific patient by ID
    @GetMapping("/{patientID}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer patientID) {
        Optional<Patient> patient = patientService.getPatientById(patientID);
        return patient.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}


