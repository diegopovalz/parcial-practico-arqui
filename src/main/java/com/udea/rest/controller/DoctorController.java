package com.udea.rest.controller;

import com.udea.rest.model.Doctor;
import com.udea.rest.model.DoctorVersion2;
import com.udea.rest.service.DoctorService;
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
@RequestMapping("/doctor")
@Api(tags = {"Controlador Doctor"})
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(final DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping(value = "/create", produces = "application/com.udea.doc-v1+json")
    @ApiOperation("Crear doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Doctor creado"),
    })
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        this.doctorService.createDoctor(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }

    @PostMapping(value = "/create", produces = "application/com.udea.doc-v2+json")
    @ApiOperation("Crear doctor")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Doctor creado"),
    })
    public ResponseEntity<DoctorVersion2> createDoctorV2(@RequestBody DoctorVersion2 doctor) {
        this.doctorService.createDoctorV2(doctor);
        return new ResponseEntity<>(doctor, HttpStatus.CREATED);
    }
}
