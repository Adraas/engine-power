package ru.wkn.calculators.impl;

import org.springframework.stereotype.Component;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.parameters.impl.ice.InternalCombustionEngineAirFlowParameters;
import ru.wkn.parameters.impl.ice.InternalCombustionEngineParameters;
import ru.wkn.parameters.impl.ice.InternalCombustionEngineTorqueParameters;
import ru.wkn.parameters.impl.ice.InternalCombustionEngineVolumeParameters;
import ru.wkn.exceptions.CalculatorNotFoundException;

@Component
public class InternalCombustionEnginePowerCalculator implements EnginePowerCalculator<InternalCombustionEngineParameters> {

    public double calculate(InternalCombustionEngineParameters parameters) throws CalculatorNotFoundException {
        if (parameters instanceof InternalCombustionEngineTorqueParameters) {
            return calculateByTorque((InternalCombustionEngineTorqueParameters) parameters);
        } else {
            if (parameters instanceof InternalCombustionEngineVolumeParameters) {
                return calculateByEngineVolume((InternalCombustionEngineVolumeParameters) parameters);
            } else {
                if (parameters instanceof InternalCombustionEngineAirFlowParameters) {
                    return calculateByAirFlow((InternalCombustionEngineAirFlowParameters) parameters);
                }
            }
        }
        throw new CalculatorNotFoundException();
    }

    private double calculateByTorque(InternalCombustionEngineTorqueParameters parameters) {
        double torque = (parameters.getEngineWorkingVolume() * parameters.getCombustionChamberEffectivePressure())
                / InternalCombustionEngineTorqueParameters.TORQUE_CONST;
        return (parameters.getShaftSpeed() * torque)
                / InternalCombustionEngineTorqueParameters.TORQUE_PROPORTIONALITY_FACTOR;
    }

    private double calculateByEngineVolume(InternalCombustionEngineVolumeParameters parameters) {
        return (parameters.getEngineVolume() * parameters.getShaftSpeed() * parameters.getMediumEffectivePressure())
                / InternalCombustionEngineVolumeParameters.ENGINE_VOLUME_PROPORTIONALITY_FACTOR;
    }

    private double calculateByAirFlow(InternalCombustionEngineAirFlowParameters parameters) {
        return parameters.getAirFlow() / InternalCombustionEngineAirFlowParameters.AIR_FLOW_CONST;
    }
}
