package com.udea.rest.model;

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
public class Patient {

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

    @Column(name = "bloodType", nullable = false, length = 80)
    @NonNull
    private String bloodType;

    @Column(name = "civilStatus", nullable = false, length = 80)
    @NonNull
    private String civilStatus;

    @Column(name = "birthDate", nullable = false)
    @NonNull
    private Date birthDate;

    @Column(name = "eps", nullable = false, length = 80)
    @NonNull
    private String eps;

    @Column(name = "rh", nullable = false, length = 80)
    @NonNull
    private String rh;

    @Column(name = "sex", nullable = false, length = 80)
    @NonNull
    private String sex;
}
