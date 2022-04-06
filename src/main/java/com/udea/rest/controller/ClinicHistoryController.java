package com.udea.rest.controller;

import com.udea.rest.model.ClinicHistory;
import com.udea.rest.service.ClinicHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hc")
@Api(tags = {"Controlador Historia Clinica"})
public class ClinicHistoryController {

    private final ClinicHistoryService clinicHistoryService;

    public ClinicHistoryController(final ClinicHistoryService clinicHistoryService) {
        this.clinicHistoryService = clinicHistoryService;
    }

    @PostMapping(value = "/create", produces = "application/com.udea.hc-v1+json")
    @ApiOperation("Crear historia clínica")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Historia clínica creada"),
            @ApiResponse(code = 404, message = "No se encontró un paciente con la cédula ingresada")
    })
    public ResponseEntity<ClinicHistory> createClinicHistory(@RequestBody ClinicHistory clinicHistory) {
        clinicHistory = this.clinicHistoryService.createClinicHistory(clinicHistory);
        return new ResponseEntity<>(clinicHistory, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all", produces = "application/com.udea.hc-v1+json")
    @ApiOperation("Consultar historias clínicas del usuario")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Historias clínicas obtenidas"),
            @ApiResponse(code = 404, message = "No se encontró un paciente con la cédula ingresada")
    })
    public ResponseEntity<List<ClinicHistory>> getPatientClinicHistories(@RequestParam String documentNumber) {
        List<ClinicHistory> histories = this.clinicHistoryService.getPatientHistories(documentNumber);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }
}
