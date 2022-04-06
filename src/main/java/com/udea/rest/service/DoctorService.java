package com.udea.rest.service;

import com.udea.rest.model.Doctor;
import com.udea.rest.model.DoctorVersion2;
import com.udea.rest.repository.DoctorRepository;
import com.udea.rest.repository.DoctorV2Repository;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorV2Repository doctorV2Repository;

    public DoctorService(final DoctorRepository doctorRepository, final DoctorV2Repository doctorV2Repository) {
        this.doctorRepository = doctorRepository;
        this.doctorV2Repository = doctorV2Repository;
    }

    public Doctor getDoctorByDocumentNumber(String documentNumber) {
        return this.doctorRepository.findByDocumentNumber(documentNumber);
    }

    public Doctor createDoctor(Doctor doctor) {
        this.doctorRepository.save(doctor);
        return doctor;
    }

    public DoctorVersion2 createDoctorV2(DoctorVersion2 doctor) {
        this.doctorV2Repository.save(doctor);
        return doctor;
    }
}
