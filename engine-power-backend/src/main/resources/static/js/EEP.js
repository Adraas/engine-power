class EEP {

    static xmlHttp = new XMLHttpRequest();

    static calculateAsynchronousElectricEnginePower() {
        EEP.xmlHttp.onload = function () {
            window.document.getElementById("aee-current").value = "";
            window.document.getElementById("aee-voltage").value = "";
            if (EEP.xmlHttp.status !== 200) {
                alert(EEP.xmlHttp.status + ": " + EEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(EEP.xmlHttp.responseText);
                window.document.getElementById("aee-result").value = json.result;
            }
        };
        EEP.xmlHttp.open("POST", "api/engine-power/calculate-asynchronous-electric-engine-power", false);
        EEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"current\": \"" + window.document.getElementById("aee-current").value + "\",\n" +
            "\"voltage\": \"" + window.document.getElementById("aee-voltage").value + "\"\n" +
            "}";
        EEP.xmlHttp.send(data);
    }

    static calculateThreePhaseElectricEnginePower() {
        EEP.xmlHttp.onload = function () {
            window.document.getElementById("tpe-phase-current").value = "";
            window.document.getElementById("tpe-phase-voltage").value = "";
            window.document.getElementById("tpe-angle-f").value = "";
            window.document.getElementById("tpe-lost-power").value = "";
            if (EEP.xmlHttp.status !== 200) {
                alert(EEP.xmlHttp.status + ": " + EEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(EEP.xmlHttp.responseText);
                window.document.getElementById("tpe-result").value = json.result;
            }
        };
        EEP.xmlHttp.open("POST", "api/engine-power/calculate-three-phase-electric-engine-power", false);
        EEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"phaseCurrent\": \"" + window.document.getElementById("tpe-phase-current").value + "\",\n" +
            "\"phaseVoltage\": \"" + window.document.getElementById("tpe-phase-voltage").value + "\",\n" +
            "\"angleF\": \"" + window.document.getElementById("tpe-angle-f").value + "\",\n" +
            "\"lostPower\": \"" + window.document.getElementById("tpe-lost-power").value + "\"\n" +
            "}";
        EEP.xmlHttp.send(data);
    }

    static calculateElectricEnginePowerByDimensions() {
        EEP.xmlHttp.onload = function () {
            window.document.getElementById("eed-core-diameter").value = "";
            window.document.getElementById("eed-shaft-speed").value = "";
            window.document.getElementById("eed-frequency").value = "";
            window.document.getElementById("eed-core-length").value = "";
            if (EEP.xmlHttp.status !== 200) {
                alert(EEP.xmlHttp.status + ": " + EEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(EEP.xmlHttp.responseText);
                window.document.getElementById("eed-result").value = json.result;
            }
        };
        EEP.xmlHttp.open("POST", "api/engine-power/calculate-electric-engine-power-by-dimensions", false);
        EEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"coreDiameter\": \"" + window.document.getElementById("eed-core-diameter").value + "\",\n" +
            "\"shaftSpeed\": \"" + window.document.getElementById("eed-shaft-speed").value + "\",\n" +
            "\"voltageFrequency\": \"" + window.document.getElementById("eed-frequency").value + "\",\n" +
            "\"coreLength\": \"" + window.document.getElementById("eed-core-length").value + "\"\n" +
            "}";
        EEP.xmlHttp.send(data);
    }

    static calculateElectricEnginePowerTractiveForce() {
        EEP.xmlHttp.onload = function () {
            window.document.getElementById("eetf-tractive-force").value = "";
            window.document.getElementById("eetf-shaft-speed").value = "";
            window.document.getElementById("eetf-core-radius").value = "";
            if (EEP.xmlHttp.status !== 200) {
                alert(EEP.xmlHttp.status + ": " + EEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(EEP.xmlHttp.responseText);
                window.document.getElementById("eetf-result").value = json.result;
            }
        };
        EEP.xmlHttp.open("POST", "api/engine-power/calculate-electric-engine-power-by-tractive-force", false);
        EEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"tractiveForce\": \"" + window.document.getElementById("eetf-tractive-force").value + "\",\n" +
            "\"shaftSpeed\": \"" + window.document.getElementById("eetf-shaft-speed").value + "\",\n" +
            "\"coreRadius\": \"" + window.document.getElementById("eetf-core-radius").value + "\"\n" +
            "}";
        EEP.xmlHttp.send(data);
    }

    static calculateDirectCurrentElectricEnginePower() {
        EEP.xmlHttp.onload = function () {
            window.document.getElementById("eedc-electromotive-force").value = "";
            window.document.getElementById("eedc-current").value = "";
            if (EEP.xmlHttp.status !== 200) {
                alert(EEP.xmlHttp.status + ": " + EEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(EEP.xmlHttp.responseText);
                window.document.getElementById("eedc-result").value = json.result;
            }
        };
        EEP.xmlHttp.open("POST", "api/engine-power/calculate-direct-current-electric-engine-power", false);
        EEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"electromotiveForce\": \"" + window.document.getElementById("eedc-electromotive-force").value + "\",\n" +
            "\"current\": \"" + window.document.getElementById("eedc-current").value + "\"\n" +
            "}";
        EEP.xmlHttp.send(data);
    }
}