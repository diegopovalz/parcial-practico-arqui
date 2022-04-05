package com.udea.rest.service;

import ch.qos.logback.core.net.server.Client;
import com.udea.rest.model.ClinicHistory;
import com.udea.rest.model.Patient;
import com.udea.rest.repository.ClinicHistoryRepository;
import com.udea.rest.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicHistoryService {

    private final ClinicHistoryRepository clinicHistoryRepository;
    private final PatientRepository patientRepository;

    public ClinicHistoryService(final ClinicHistoryRepository clinicHistoryRepository, final PatientRepository patientRepository) {
        this.clinicHistoryRepository = clinicHistoryRepository;
        this.patientRepository = patientRepository;
    }

    public List<ClinicHistory> getPatientHistories(String documentNumber) {
        Patient patient = this.patientRepository.findByDocumentNumber(documentNumber);
        List<ClinicHistory> clinicHistories = this.clinicHistoryRepository.findClinicHistoriesByPatientId(patient.getId())
                .orElse(null);
        return clinicHistories;
    }

    public ClinicHistory createClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistoryRepository.save(clinicHistory);
        return clinicHistory;
    }
}
