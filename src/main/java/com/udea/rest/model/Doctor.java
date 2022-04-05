package com.udea.rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "documentType", nullable = false, length = 3)
    @NonNull
    private String documentType;

    @Column(name = "documentNumber", nullable = false, length = 11)
    @NonNull
    private String documentNumber;

    @Column(name = "firstName", nullable = false, length = 80)
    @NonNull
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 80)
    @NonNull
    private String lastName;
}
