package com.udea.rest.service;

import com.udea.rest.exception.patient.PatientNotFoundException;
import com.udea.rest.model.Patient;
import com.udea.rest.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(final PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient getPatientByDocumentNumber(String documentNumber) {
        return this.patientRepository
                .findByDocumentNumber(documentNumber)
                .orElseThrow(() -> new PatientNotFoundException("El paciente con documento " + documentNumber + " no fue encontrado"));
    }

    public Patient createPatient(Patient patient) {
        this.patientRepository.save(patient);
        return patient;
    }
}
