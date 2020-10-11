package ru.wkn.calculators.impl;

import org.springframework.stereotype.Component;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.exceptions.CalculatorNotFoundException;
import ru.wkn.parameters.impl.ee.*;

@Component
public class ElectricEnginePowerCalculator implements EnginePowerCalculator<ElectricEngineParameters> {

    public double calculate(ElectricEngineParameters parameters) throws CalculatorNotFoundException {
        if (parameters instanceof AsynchronousElectricEngineParameters) {
            return calculateForAsynchronous((AsynchronousElectricEngineParameters) parameters);
        } else {
            if (parameters instanceof ThreePhaseElectricEngineParameters) {
                return calculateByEngineVolume((ThreePhaseElectricEngineParameters) parameters);
            } else {
                if (parameters instanceof ElectricEngineDimensionsParameters) {
                    return calculateByAirFlow((ElectricEngineDimensionsParameters) parameters);
                } else {
                    if (parameters instanceof ElectricEngineTractiveForceParameters) {
                        return calculateByTractiveForce((ElectricEngineTractiveForceParameters) parameters);
                    } else {
                        if (parameters instanceof ElectricEngineDirectCurrentParameters) {
                            return calculateForDirectCurrent((ElectricEngineDirectCurrentParameters) parameters);
                        }
                    }
                }
            }
        }
        throw new CalculatorNotFoundException();
    }

    private double calculateForAsynchronous(AsynchronousElectricEngineParameters parameters) {
        return parameters.getCurrent() * parameters.getVoltage();
    }

    private double calculateByEngineVolume(ThreePhaseElectricEngineParameters parameters) {
        double statorPower = ThreePhaseElectricEngineParameters.THREE_PHASE_CONST * parameters.getPhaseVoltage()
                * parameters.getPhaseCurrent() * Math.cos(parameters.getAngleF());
        return statorPower - parameters.getLostPower();
    }

    private double calculateByAirFlow(ElectricEngineDimensionsParameters parameters) {
        double cons = (Math.PI * parameters.getCoreDiameter() * parameters.getShaftSpeed())
                / (ElectricEngineDimensionsParameters.DIVIDE_DIMENSIONS_CONST * parameters.getVoltageFrequency());
        return cons * Math.pow(parameters.getCoreDiameter(), 2) * parameters.getCoreLength()
                * parameters.getShaftSpeed() * ElectricEngineDimensionsParameters.MULTIPLE_DIMENSIONS_CONST;
    }

    private double calculateByTractiveForce(ElectricEngineTractiveForceParameters parameters) {
        return 2 * Math.PI * parameters.getTractiveForce() * parameters.getShaftSpeed() * parameters.getCoreRadius();
    }

    private double calculateForDirectCurrent(ElectricEngineDirectCurrentParameters parameters) {
        return parameters.getElectromotiveForce() + parameters.getCurrent();
    }
}
