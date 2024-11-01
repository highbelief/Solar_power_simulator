# 태양광 발전 시뮬레이터

이 프로젝트는 **대학 캡스톤 디자인 과목**의 일환으로 개발된 **태양광 발전 시뮬레이터**입니다. 본 시뮬레이터는 **교육 목적**으로만 사용해야 하며, 그 외의 용도로 사용을 금지합니다. 이 시스템의 사용으로 인한 모든 책임은 사용자에게 있습니다.

## 프로젝트 개요

태양광 발전 시뮬레이터는 다음과 같은 환경 변수를 고려하여 **태양광 발전소의 발전량을 예측하고 모니터링**할 수 있는 시스템입니다.

- **기온**: 주변 온도에 따른 발전량의 변동성 반영
- **일사량**: 태양광 발전의 주요 요소로, 발전량에 직접적인 영향을 줌
- **습도**: 높은 습도나 악천후가 발전량에 미치는 영향
- **구름량**: 구름량에 따라 발전 효율이 감소
- **장비 상태**: 장비의 정상 작동 여부에 따른 발전량의 변화

주기적으로 발전량을 계산하고 시뮬레이션 데이터를 저장하여, 발전소의 운영과 다양한 환경 변수에서의 발전량 변동성을 분석할 수 있습니다.

## 사용 제한

본 프로젝트는 **교육 목적** 외 사용을 엄격히 금지합니다. 시스템의 사용으로 인해 발생하는 모든 문제와 책임은 사용자에게 있습니다. 프로젝트의 재배포, 상업적 사용, 혹은 비교육적 용도의 사용은 허용되지 않습니다.

## 프로젝트 기능

- **태양광 발전량 시뮬레이션**: 환경 요소와 장비 상태를 고려하여 태양광 발전량을 계산
- **실시간 데이터 전송**: 10분 간격으로 발전량 데이터를 업데이트하여 서버에 저장
- **발전량 변동성 반영**: 일사량과 구름량의 변동성에 따라 발전량이 변화
- **장비 상태 모니터링**: 장비 고장 여부에 따라 발전량 자동 조정

## 시스템 요구 사항

- **Java 21** 이상
- **MySQL** 데이터베이스 (5.7 이상 권장)
- **Node.js** 및 웹 브라우저
- **Spring Boot** 프레임워크 (3.0 이상)
- **프론트엔드**: HTML, CSS, JavaScript

## 설치 및 실행

1. **프로젝트 클론**: 이 저장소를 로컬 시스템에 클론합니다.
   ```bash
   git clone https://github.com/highbelief/solar-power-simulator.git
   cd solar-power-simulator
   ```

2. **데이터베이스 설정**: MySQL에서 데이터베이스와 테이블을 생성하고, `application.properties` 파일에 데이터베이스 연결 정보를 설정합니다.
   ```sql
   CREATE DATABASE SolarDB;
   USE SolarDB;

   CREATE TABLE simulation_data (
       id BIGINT AUTO_INCREMENT PRIMARY KEY,
       observation_time TIMESTAMP NOT NULL,
       temperature DOUBLE,
       solar_irradiance DOUBLE,
       humidity DOUBLE,
       cloud_coverage DOUBLE,
       equipment_status VARCHAR(255),
       power_generated DOUBLE,
       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
   );
   ```

3. **환경 설정**: `application.properties` 파일에서 데이터베이스 정보, 포트 등을 설정합니다.
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/SolarDB
   spring.datasource.username=your_db_username
   spring.datasource.password=your_db_password
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   ```

4. **백엔드 실행**: 프로젝트 루트 디렉토리에서 Spring Boot 애플리케이션을 실행합니다.
   ```bash
   ./gradlew bootRun
   ```

5. **프론트엔드 실행**: 웹 브라우저에서 `http://localhost:8080`으로 접속하여 시뮬레이터를 사용합니다.

## 사용 방법

- **환경 설정**: 각 시뮬레이션 시작 시 기온, 일사량, 습도, 구름량 등을 설정하여 발전량 변화를 시뮬레이션합니다.
- **실시간 모니터링**: 10분 간격으로 시스템이 자동으로 발전량을 계산하여 서버에 전송합니다.
- **장비 상태 변경**: 장비가 고장났을 경우 발전량이 자동으로 조정되며, 시뮬레이션이 중단될 수 있습니다.

## 주요 코드 구조

- **`model`**: 시뮬레이션 데이터의 엔티티 클래스 (`SimulationData.java`)
- **`repository`**: 데이터베이스 접근을 위한 리포지토리 인터페이스 (`SimulationRepository.java`)
- **`service`**: 시뮬레이션 데이터 저장을 위한 서비스 클래스 (`SimulationService.java`)
- **`controller`**: 시뮬레이션 데이터 생성 및 저장을 위한 컨트롤러 클래스 (`SimulationController.java`)
- **프론트엔드**: HTML, JavaScript, CSS 파일로 구성된 클라이언트 애플리케이션

## 주의사항

- **실제 환경과의 차이**: 본 프로젝트는 실제 태양광 발전 환경의 다양한 변수를 모두 반영하지 않으며, 실사용에 적합하지 않을 수 있습니다.
- **테스트 데이터 사용 권장**: 본 시스템은 교육 및 실험용이므로 실제 데이터를 사용하는 대신 테스트 데이터를 사용하는 것을 권장합니다.

## 라이선스

본 프로젝트는 **교육 목적으로만** 사용 가능하며, 상업적 사용이나 재배포를 금지합니다. 본 프로젝트의 모든 저작권은 개발자에게 있으며, 프로젝트 사용으로 인해 발생하는 문제에 대한 책임은 사용자에게 있습니다.

---

