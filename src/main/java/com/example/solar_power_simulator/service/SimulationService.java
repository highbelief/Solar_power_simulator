package com.example.solar_power_simulator.service;

import com.example.solar_power_simulator.model.SimulationData;
import com.example.solar_power_simulator.repository.SimulationRepository;
import org.springframework.stereotype.Service;

@Service
public class SimulationService {

    private final SimulationRepository simulationRepository;

    public SimulationService(SimulationRepository simulationRepository) {
        this.simulationRepository = simulationRepository;
    }

    public SimulationData saveSimulationData(SimulationData data) {
        return simulationRepository.save(data);
    }
}
