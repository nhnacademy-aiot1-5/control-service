package live.ioteatime.controlservice.domain;

import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum Sensor {
    LIGHT(7, "light"),
    AC(8, "ac"),
    CONTROLLER(0, "controller");

    private int sensorNumber;
    private String sensorName;

    Sensor(int sensorNumber, String sensorName) {
        this.sensorNumber = sensorNumber;
        this.sensorName = sensorName;
    }

    private static final Map<Integer, Sensor> integerSensorMap = Arrays.stream(Sensor.values())
            .collect(Collectors.toMap(Sensor::getSensorNumber, Function.identity()));
    private static final Map<String, Sensor> stringSensorMap = Arrays.stream(Sensor.values())
            .collect(Collectors.toMap(Sensor::getSensorName, Function.identity()));
    private static final Map<String, Integer> sensorIntegerMap = Arrays.stream(Sensor.values())
            .collect(Collectors.toMap(Sensor::getSensorName, Sensor::getSensorNumber));

    public static Sensor getSensorFromNumber(int sensorNumber) {
        return integerSensorMap.get(sensorNumber);
    }

    public static Sensor getSensorFromName(String sensorName) {
        return stringSensorMap.get(sensorName);
    }

    public static int getSensorNumberFromName(String sensorName) {
        return sensorIntegerMap.get(sensorName);
    }
}
