package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.parameters.EnginePowerParameters;

@AllArgsConstructor
@Getter
public abstract class ElectricEngineParameters extends EnginePowerParameters {

    public static final int THREE_PHASE_CONST = 3;

    public static final int DIVIDE_DIMENSIONS_CONST = 120;
    public static final double MULTIPLE_DIMENSIONS_CONST = 0.00001;
}
