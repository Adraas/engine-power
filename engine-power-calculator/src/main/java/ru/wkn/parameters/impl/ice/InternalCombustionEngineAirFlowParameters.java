package ru.wkn.parameters.impl.ice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InternalCombustionEngineAirFlowParameters extends InternalCombustionEngineParameters {

    private double airFlow;
}
