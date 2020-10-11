package ru.wkn.calculators;

import ru.wkn.parameters.EnginePowerParameters;
import ru.wkn.exceptions.CalculatorNotFoundException;

public interface EnginePowerCalculator<T extends EnginePowerParameters> {

    double calculate(T enginePowerParameters) throws CalculatorNotFoundException;
}
