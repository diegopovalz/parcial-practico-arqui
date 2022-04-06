package com.udea.rest.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "doctorId", nullable = false)
    @NonNull
    private Long doctorId;

    @Column(name = "patientId", nullable = false)
    @NonNull
    private Long patientId;

    @Column(name = "illness", nullable = false, length = 80)
    @NonNull
    private String illness;

    @Column(name = "historyDate", nullable = false)
    @NonNull
    private Date historyDate;
}
