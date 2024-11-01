package com.example.solar_power_simulator.controller;

import com.example.solar_power_simulator.model.SimulationData;
import com.example.solar_power_simulator.service.SimulationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/simulation")
public class SimulationController {

    private final SimulationService simulationService;

    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @PostMapping
    public SimulationData createSimulationData(@RequestBody SimulationData data) {
        return simulationService.saveSimulationData(data);
    }
}
