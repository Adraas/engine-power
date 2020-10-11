class SEP {

    static xmlHttp = new XMLHttpRequest();

    static calculateSteamEnginePower() {
        SEP.xmlHttp.onload = function () {
            window.document.getElementById("se-piston-medium-pressure").value = "";
            window.document.getElementById("se-piston-stroke").value = "";
            window.document.getElementById("se-piston-area").value = "";
            window.document.getElementById("se-frequency").value = "";
            if (SEP.xmlHttp.status !== 200) {
                alert(SEP.xmlHttp.status + ": " + SEP.xmlHttp.statusText);
            } else {
                let json = JSON.parse(SEP.xmlHttp.responseText);
                window.document.getElementById("se-result").value = json.result;
            }
        };
        SEP.xmlHttp.open("POST", "api/engine-power/calculate-steam-engine-power", false);
        SEP.xmlHttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
        let data = "{\n" +
            "\"pistonMediumPressure\": \"" + window.document.getElementById("se-piston-medium-pressure").value + "\",\n" +
            "\"pistonStroke\": \"" + window.document.getElementById("se-piston-stroke").value + "\",\n" +
            "\"pistonArea\": \"" + window.document.getElementById("se-piston-area").value + "\",\n" +
            "\"frequency\": \"" + window.document.getElementById("se-frequency").value + "\"\n" +
            "}";
        SEP.xmlHttp.send(data);
    }
}