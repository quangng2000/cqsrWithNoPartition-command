package com.nguyen.cqsrWithNoPartition.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyen.cqsrWithNoPartition.dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
