package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ElectricEngineDirectCurrentParameters extends ElectricEngineParameters {

    private double electromotiveForce;
    private double current;
}
