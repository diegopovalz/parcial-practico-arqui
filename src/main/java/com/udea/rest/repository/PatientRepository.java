package com.udea.rest.repository;

import com.udea.rest.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByDocumentNumber(String documentNumber);
}
