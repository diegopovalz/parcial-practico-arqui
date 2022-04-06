package com.udea.rest.repository;

import com.udea.rest.model.DoctorVersion2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorV2Repository extends JpaRepository<DoctorVersion2, Long> {
}
