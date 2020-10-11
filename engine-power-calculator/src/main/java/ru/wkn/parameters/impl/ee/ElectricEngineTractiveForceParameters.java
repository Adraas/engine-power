package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ElectricEngineTractiveForceParameters extends ElectricEngineParameters {

    private double tractiveForce;
    private double shaftSpeed;
    private double coreRadius;
}
