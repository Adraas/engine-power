package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ThreePhaseElectricEngineParameters extends ElectricEngineParameters {

    private double phaseCurrent;
    private double phaseVoltage;
    private double angleF;
    private double lostPower;
}
