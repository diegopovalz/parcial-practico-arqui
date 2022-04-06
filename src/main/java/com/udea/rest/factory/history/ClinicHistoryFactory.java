package com.udea.rest.factory.history;

import com.udea.rest.dto.ClinicHistoryDto;
import com.udea.rest.model.ClinicHistory;
import com.udea.rest.model.Doctor;
import com.udea.rest.model.Patient;
import com.udea.rest.service.DoctorService;
import com.udea.rest.service.PatientService;
import org.springframework.stereotype.Component;

@Component
public class ClinicHistoryFactory {

    private final DoctorService doctorService;
    private final PatientService patientService;

    public ClinicHistoryFactory(final DoctorService doctorService, final PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public ClinicHistory createClinicHistory(ClinicHistoryDto clinicHistoryDto) {
        Doctor doctor = this.doctorService.getDoctorByDocumentNumber(clinicHistoryDto.getDoctorDocument());
        Patient patient = this.patientService.getPatientByDocumentNumber(clinicHistoryDto.getPatientDocument());
        ClinicHistory clinicHistory = new ClinicHistory();
        clinicHistory.setIllness(clinicHistoryDto.getIllness());
        clinicHistory.setHistoryDate(clinicHistoryDto.getHistoryDate());
        clinicHistory.setDoctor(doctor);
        clinicHistory.setPatient(patient);
        return clinicHistory;
    }
}
