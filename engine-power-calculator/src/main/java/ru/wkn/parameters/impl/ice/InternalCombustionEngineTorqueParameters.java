package ru.wkn.parameters.impl.ice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InternalCombustionEngineTorqueParameters extends InternalCombustionEngineParameters {

    private double engineWorkingVolume;
    private double combustionChamberEffectivePressure;
    private double shaftSpeed;
}
