package ru.wkn.parameters.impl.se;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.parameters.EnginePowerParameters;

@AllArgsConstructor
@Getter
public abstract class SteamEngineParameters extends EnginePowerParameters {

    public static final int STEAM_ENGINE_CONST = 33000;
}
