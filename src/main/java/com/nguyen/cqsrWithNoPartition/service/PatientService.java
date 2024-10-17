package com.nguyen.cqsrWithNoPartition.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyen.cqsrWithNoPartition.aspect.PatientNotFoundException;
import com.nguyen.cqsrWithNoPartition.dto.Patient;
import com.nguyen.cqsrWithNoPartition.repo.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Create a new patient
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    // Update an existing patient
    @Transactional
    public Patient updatePatient(Integer patientID, Patient updatedPatient) {
        Optional<Patient> existingPatient = patientRepository.findById(patientID);
        if (existingPatient.isPresent()) {
            Patient patient = existingPatient.get();
            patient.setFirstName(updatedPatient.getFirstName());
            patient.setLastName(updatedPatient.getLastName());
            return patientRepository.save(patient);
        } else {
            throw new PatientNotFoundException("Patient not found with ID: " + patientID);
        }
    }

    // Delete a patient by ID
    @Transactional
    public void deletePatient(Integer patientID) {
        patientRepository.deleteById(patientID);
    }

    // Retrieve a list of all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Retrieve a specific patient by ID
    public Optional<Patient> getPatientById(Integer patientID) {
        return patientRepository.findById(patientID);
    }
}

