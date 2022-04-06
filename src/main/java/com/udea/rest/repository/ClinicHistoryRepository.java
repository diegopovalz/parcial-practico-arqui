package com.udea.rest.repository;

import com.udea.rest.model.ClinicHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicHistoryRepository extends JpaRepository<ClinicHistory, Long> {
    List<ClinicHistory> findClinicHistoriesByPatientId(Long patientId);
}
