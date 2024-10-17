package com.nguyen.cqsrWithNoPartition.dto;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Visits")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Visit {

    @Id
    private Integer visitID;

    @ManyToOne
    @JoinColumn(name = "patientID", nullable = false)
    private Patient patient;

    @Temporal(TemporalType.DATE)
    private Date visitDate;
}

