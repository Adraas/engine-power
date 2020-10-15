package ru.wkn.rest.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.exceptions.CalculatorNotFoundException;
import ru.wkn.parameters.impl.ee.*;
import ru.wkn.parameters.impl.ice.*;
import ru.wkn.parameters.impl.se.*;
import ru.wkn.rest.dto.EnginePowerResultDTO;

import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping(path = "api/engine-power")
@RequiredArgsConstructor
public class EnginePowerCalculatorController {

    private final EnginePowerCalculator<ElectricEngineParameters> electricEnginePowerCalculator;
    private final EnginePowerCalculator<InternalCombustionEngineParameters> internalCombustionEnginePowerCalculator;
    private final EnginePowerCalculator<SteamEngineParameters> steamEnginePowerCalculator;

    @PostMapping(path = "/calculate-asynchronous-electric-engine-power", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateAsynchronousElectricEnginePower(
            @RequestBody AsynchronousElectricEngineParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(electricEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-electric-engine-power-by-dimensions", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateElectricEnginePowerByDimensions(
            @RequestBody ElectricEngineDimensionsParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(electricEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-three-phase-electric-engine-power", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateThreePhaseElectricEnginePower(
            @RequestBody ThreePhaseElectricEngineParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(electricEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-electric-engine-power-by-tractive-force", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateElectricEnginePowerByTractiveForce(
            @RequestBody ElectricEngineTractiveForceParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(electricEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-direct-current-electric-engine-power", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateDirectCurrentElectricEnginePower(
            @RequestBody ElectricEngineDirectCurrentParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(electricEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-internal-combustion-engine-power-by-air-flow",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateInternalCombustionEnginePowerByAirFlow(
            @RequestBody InternalCombustionEngineAirFlowParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(internalCombustionEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-internal-combustion-engine-power-by-torque",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateInternalCombustionEnginePowerByTorque(
            @RequestBody InternalCombustionEngineTorqueParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(internalCombustionEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-internal-combustion-engine-power-by-volume",
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateInternalCombustionEnginePowerByVolume(
            @RequestBody InternalCombustionEngineVolumeParameters parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(internalCombustionEnginePowerCalculator.calculate(parameters)).build());
    }

    @PostMapping(path = "/calculate-steam-engine-power", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EnginePowerResultDTO> calculateSteamEnginePower(
            @RequestBody SteamEngineParametersImpl parameters) throws CalculatorNotFoundException {
        return ok().body(EnginePowerResultDTO
                .builder().result(steamEnginePowerCalculator.calculate(parameters)).build());
    }
}
