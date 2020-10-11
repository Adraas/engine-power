package ru.wkn.parameters.impl.ice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.parameters.EnginePowerParameters;

@AllArgsConstructor
@Getter
public abstract class InternalCombustionEngineParameters extends EnginePowerParameters {

    public static final double TORQUE_CONST = 0.12566;
    public static final int TORQUE_PROPORTIONALITY_FACTOR = 9549;

    public static final int ENGINE_VOLUME_PROPORTIONALITY_FACTOR = 120;

    public static final int AIR_FLOW_CONST = 3;
}
