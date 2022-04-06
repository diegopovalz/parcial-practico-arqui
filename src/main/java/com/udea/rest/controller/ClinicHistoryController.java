package com.udea.rest.controller;

import com.udea.rest.model.ClinicHistory;
import com.udea.rest.service.ClinicHistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hc")
public class ClinicHistoryController {

    private final ClinicHistoryService clinicHistoryService;

    public ClinicHistoryController(final ClinicHistoryService clinicHistoryService) {
        this.clinicHistoryService = clinicHistoryService;
    }

    @PostMapping(value = "/create", produces = "application/com.udea.hc-v1+json")
    public ResponseEntity<ClinicHistory> createClinicHistory(@RequestBody ClinicHistory clinicHistory) {
        clinicHistory = this.clinicHistoryService.createClinicHistory(clinicHistory);
        return new ResponseEntity<>(clinicHistory, HttpStatus.CREATED);
    }

    @GetMapping(value = "/all", produces = "application/com.udea.hc-v1+json")
    public ResponseEntity<List<ClinicHistory>> getPatientClinicHistories(@RequestParam String documentNumber) {
        List<ClinicHistory> histories = this.clinicHistoryService.getPatientHistories(documentNumber);
        return new ResponseEntity<>(histories, HttpStatus.OK);
    }
}
