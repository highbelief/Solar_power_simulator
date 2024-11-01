package com.example.solar_power_simulator.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "simulation_data")
public class SimulationData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Timestamp observationTime;  // 데이터 관측 시간
    private Double temperature;         // 기온 (°C)
    private Double solarIrradiance;     // 일사량 (W/m²)
    private Double humidity;            // 습도 (%)
    private Double cloudCoverage;       // 구름량 (%)
    private String equipmentStatus;     // 장비 상태 (정상, 고장 등)
    private Double powerGenerated;      // 발전량 (kW)
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis()); // 데이터 생성 시간

    // Getters and Setters for all fields
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Timestamp getObservationTime() { return observationTime; }
    public void setObservationTime(Timestamp observationTime) { this.observationTime = observationTime; }

    public Double getTemperature() { return temperature; }
    public void setTemperature(Double temperature) { this.temperature = temperature; }

    public Double getSolarIrradiance() { return solarIrradiance; }
    public void setSolarIrradiance(Double solarIrradiance) { this.solarIrradiance = solarIrradiance; }

    public Double getHumidity() { return humidity; }
    public void setHumidity(Double humidity) { this.humidity = humidity; }

    public Double getCloudCoverage() { return cloudCoverage; }
    public void setCloudCoverage(Double cloudCoverage) { this.cloudCoverage = cloudCoverage; }

    public String getEquipmentStatus() { return equipmentStatus; }
    public void setEquipmentStatus(String equipmentStatus) { this.equipmentStatus = equipmentStatus; }

    public Double getPowerGenerated() { return powerGenerated; }
    public void setPowerGenerated(Double powerGenerated) { this.powerGenerated = powerGenerated; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
