package ru.wkn.calculators.impl;

import org.springframework.stereotype.Component;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.parameters.impl.se.SteamEngineParametersImpl;

@Component
public class SteamEnginePowerCalculator implements EnginePowerCalculator<SteamEngineParametersImpl> {

    public double calculate(SteamEngineParametersImpl parameters) {
        return (parameters.getPistonMediumPressure() * parameters.getPistonStroke() * parameters.getPistonArea()
                * parameters.getFrequency()) / SteamEngineParametersImpl.STEAM_ENGINE_CONST;
    }
}
