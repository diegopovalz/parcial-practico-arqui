package com.udea.rest.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorVersion2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(hidden = true)
    private Long id;

    @Column(name = "documentNumber", nullable = false, length = 11)
    @NonNull
    private String documentNumber;

    @Column(name = "fullName", nullable = false, length = 100)
    @NonNull
    private String fullName;
}
