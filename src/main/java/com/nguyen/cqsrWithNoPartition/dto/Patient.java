package com.nguyen.cqsrWithNoPartition.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    private Integer patientID;
    private String firstName;
    private String lastName;
}




