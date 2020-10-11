package ru.wkn.parameters.impl.ice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class InternalCombustionEngineVolumeParameters extends InternalCombustionEngineParameters {

    private double engineVolume;
    private double mediumEffectivePressure;
    private double shaftSpeed;
}
