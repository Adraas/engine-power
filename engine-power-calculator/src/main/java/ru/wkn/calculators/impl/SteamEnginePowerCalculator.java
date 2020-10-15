package ru.wkn.calculators.impl;

import org.springframework.stereotype.Component;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.exceptions.CalculatorNotFoundException;
import ru.wkn.parameters.impl.se.SteamEngineParameters;
import ru.wkn.parameters.impl.se.SteamEngineParametersImpl;

@Component
public class SteamEnginePowerCalculator implements EnginePowerCalculator<SteamEngineParameters> {

    public double calculate(SteamEngineParameters parameters) throws CalculatorNotFoundException {
        if (parameters instanceof SteamEngineParametersImpl) {
            return calculateForInchSystem((SteamEngineParametersImpl) parameters);
        }
        throw new CalculatorNotFoundException();
    }

    private double calculateForInchSystem(SteamEngineParametersImpl parameters) {
        return (parameters.getPistonMediumPressure() * parameters.getPistonStroke() * parameters.getPistonArea()
                * parameters.getFrequency()) / SteamEngineParametersImpl.STEAM_ENGINE_CONST;
    }
}
