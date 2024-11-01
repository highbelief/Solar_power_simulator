document.getElementById("simulationForm").addEventListener("submit", function (event) {
    event.preventDefault();
    startSimulation();
});

function updateValue(displayId, value) {
    const unit = displayId === 'cloudValue' ? '%' : displayId === 'irradianceValue' ? ' W/㎡' : '°C';
    document.getElementById(displayId).textContent = `${value}${unit}`;
}

// 10분마다 발전량을 업데이트하는 함수
function startSimulation() {
    sendSimulationData(); // 초기 데이터 전송

    setInterval(() => {
        sendSimulationData(); // 10분 간격으로 데이터 전송
    }, 10 * 60 * 1000); // 10분마다 실행
}

function sendSimulationData() {
    const temperature = document.getElementById("temperature").value;
    const solarIrradiance = document.getElementById("solarIrradiance").value;
    const humidity = document.getElementById("humidity").value;
    const cloudCoverage = document.getElementById("cloudCoverage").value;
    const equipmentStatus = document.querySelector('input[name="equipmentStatus"]:checked').value;

    // 발전량 계산 (예시: 일사량과 구름량을 바탕으로 계산하며 약간의 변동성을 추가)
    const maxCapacity = 520; // 발전소 최대 발전량 (520 kW)
    const efficiency = 1 - cloudCoverage / 100; // 구름량에 따른 효율 감소
    const randomFactor = 0.9 + Math.random() * 0.2; // 10% 내외의 변동성 추가
    const powerGenerated = (solarIrradiance / 1000) * maxCapacity * efficiency * randomFactor; // 변동성 포함 발전량 계산

    const data = {
        temperature: temperature,
        solarIrradiance: solarIrradiance,
        humidity: humidity,
        cloudCoverage: cloudCoverage,
        equipmentStatus: equipmentStatus,
        powerGenerated: powerGenerated.toFixed(2), // 소수점 2자리
        observationTime: new Date(),
    };

    fetch("http://localhost:8080/api/simulation", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    })
        .then(response => response.json())
        .then(data => {
            displaySimulationResult(data);
        })
        .catch(error => console.error("Error:", error));
}

function displaySimulationResult(data) {
    console.log("시뮬레이션 결과:", data);
}
