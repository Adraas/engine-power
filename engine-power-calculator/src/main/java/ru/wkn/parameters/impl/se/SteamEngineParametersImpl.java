package ru.wkn.parameters.impl.se;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SteamEngineParametersImpl extends SteamEngineParameters {

    private double pistonMediumPressure;
    private double pistonStroke;
    private double pistonArea;
    private int frequency;
}
