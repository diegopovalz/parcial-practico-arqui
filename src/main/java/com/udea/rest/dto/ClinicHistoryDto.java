package com.udea.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicHistoryDto {

    private String doctorDocument;
    private String patientDocument;
    private Date historyDate;
    private String illness;
}
