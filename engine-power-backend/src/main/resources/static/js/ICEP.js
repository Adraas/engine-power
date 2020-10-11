class ICEPC {

    static xmlHttp = new XMLHttpRequest();

    static calculateInternalCombustionEnginePowerByTorque() {
        ICEPC.xmlHttp.onload = function () {
            window.document.getElementById("ice-torque-working-engine-volume").value = "";
            window.document.getElementById("ice-torque-effective-pressure").value = "";
            window.document.getElementById("ice-torque-shaft-speed").value = "";
            if (ICEPC.xmlHttp.status !== 200) {
                alert(ICEPC.xmlHttp.status + ": " + ICEPC.xmlHttp.statusText);
            } else {
                let json = JSON.parse(ICEPC.xmlHttp.responseText);
                window.document.getElementById("ice-torque-result").value = json.result;
            }
        };
        ICEPC.xmlHttp.open("POST", "api/engine-power/calculate-internal-combustion-engine-power-by-torque", false);
        ICEPC.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"engineWorkingVolume\": \"" + window.document.getElementById("ice-torque-working-engine-volume").value + "\",\n" +
            "\"combustionChamberEffectivePressure\": \"" + window.document.getElementById("ice-torque-effective-pressure").value + "\",\n" +
            "\"shaftSpeed\": \"" + window.document.getElementById("ice-torque-shaft-speed").value + "\"\n" +
            "}";
        ICEPC.xmlHttp.send(data);
    }

    static calculateInternalCombustionEnginePowerByVolume() {
        ICEPC.xmlHttp.onload = function () {
            window.document.getElementById("ice-volume-engine-volume").value = "";
            window.document.getElementById("ice-volume-medium-effective-pressure").value = "";
            window.document.getElementById("ice-volume-shaft-speed").value = "";
            if (ICEPC.xmlHttp.status !== 200) {
                alert(ICEPC.xmlHttp.status + ": " + ICEPC.xmlHttp.statusText);
            } else {
                let json = JSON.parse(ICEPC.xmlHttp.responseText);
                window.document.getElementById("ice-volume-result").value = json.result;
            }
        };
        ICEPC.xmlHttp.open("POST", "api/engine-power/calculate-internal-combustion-engine-power-by-volume", false);
        ICEPC.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"engineVolume\": \"" + window.document.getElementById("ice-volume-engine-volume").value + "\",\n" +
            "\"mediumEffectivePressure\": \"" + window.document.getElementById("ice-volume-medium-effective-pressure").value + "\",\n" +
            "\"shaftSpeed\": \"" + window.document.getElementById("ice-volume-shaft-speed").value + "\"\n" +
            "}";
        ICEPC.xmlHttp.send(data);
    }

    static calculateInternalCombustionEnginePowerByAirFlow() {
        ICEPC.xmlHttp.onload = function () {
            window.document.getElementById("ice-air-flow-air-flow").value = "";
            if (ICEPC.xmlHttp.status !== 200) {
                alert(ICEPC.xmlHttp.status + ": " + ICEPC.xmlHttp.statusText);
            } else {
                let json = JSON.parse(ICEPC.xmlHttp.responseText);
                window.document.getElementById("ice-air-flow-result").value = json.result;
            }
        };
        ICEPC.xmlHttp.open("POST", "api/engine-power/calculate-internal-combustion-engine-power-by-air-flow", false);
        ICEPC.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"airFlow\": \"" + window.document.getElementById("ice-air-flow-air-flow").value + "\"\n" +
            "}";
        ICEPC.xmlHttp.send(data);
    }
}