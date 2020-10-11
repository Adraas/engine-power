package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ElectricEngineDimensionsParameters extends ElectricEngineParameters {

    private double coreDiameter;
    private double shaftSpeed;
    private double voltageFrequency;
    private double coreLength;
}
