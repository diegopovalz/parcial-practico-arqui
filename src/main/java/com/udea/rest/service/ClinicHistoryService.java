package com.udea.rest.service;

import com.udea.rest.model.ClinicHistory;
import com.udea.rest.model.Patient;
import com.udea.rest.repository.ClinicHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClinicHistoryService {

    private final ClinicHistoryRepository clinicHistoryRepository;
    private final PatientService patientService;

    public ClinicHistoryService(final ClinicHistoryRepository clinicHistoryRepository, final PatientService patientService) {
        this.clinicHistoryRepository = clinicHistoryRepository;
        this.patientService = patientService;
    }

    public List<ClinicHistory> getPatientHistories(String documentNumber) {
        Patient patient = this.patientService.getPatientByDocumentNumber(documentNumber);
        List<ClinicHistory> clinicHistories = this.clinicHistoryRepository.findClinicHistoriesByPatientId(patient.getId());
        return clinicHistories;
    }

    public ClinicHistory createClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistoryRepository.save(clinicHistory);
        return clinicHistory;
    }
}
