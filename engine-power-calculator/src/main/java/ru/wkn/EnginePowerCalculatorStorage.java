package ru.wkn;

import lombok.RequiredArgsConstructor;
import ru.wkn.calculators.EnginePowerCalculator;
import ru.wkn.parameters.impl.ee.ElectricEngineParameters;
import ru.wkn.parameters.impl.ice.InternalCombustionEngineParameters;
import ru.wkn.parameters.impl.se.SteamEngineParametersImpl;

@RequiredArgsConstructor
public class EnginePowerCalculatorStorage {

    private final EnginePowerCalculator<InternalCombustionEngineParameters> internalCombustionEnginePowerCalculator;
    private final EnginePowerCalculator<ElectricEngineParameters> electricEnginePowerCalculator;
    private final EnginePowerCalculator<SteamEngineParametersImpl> steamEnginePowerCalculator;
}
