package com.nguyen.cqsrWithNoPartition.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nguyen.cqsrWithNoPartition.dto.Visit;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
}
