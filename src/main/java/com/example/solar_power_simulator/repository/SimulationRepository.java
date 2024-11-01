package com.example.solar_power_simulator.repository;

import com.example.solar_power_simulator.model.SimulationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationRepository extends JpaRepository<SimulationData, Long> {
}
