package ru.wkn.parameters.impl.ee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AsynchronousElectricEngineParameters extends ElectricEngineParameters {

    private double current;
    private double voltage;
}
