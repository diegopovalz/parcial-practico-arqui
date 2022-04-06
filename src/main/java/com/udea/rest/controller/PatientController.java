package com.udea.rest.controller;

import com.udea.rest.model.Doctor;
import com.udea.rest.model.Patient;
import com.udea.rest.service.DoctorService;
import com.udea.rest.service.PatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@Api(tags = {"Controlador Paciente"})
public class PatientController {
    private final PatientService patientService;

    public PatientController(final PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping(value = "/create", produces = "application/com.udea.hc-v1+json")
    @ApiOperation("Crear paciente")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Paciente creado"),
    })
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        this.patientService.createPatient(patient);
        return new ResponseEntity<>(patient, HttpStatus.CREATED);
    }
}
