package live.ioteatime.controlservice.service;

import live.ioteatime.controlservice.domain.Payload;
import live.ioteatime.controlservice.domain.Sensor;
import org.springframework.stereotype.Service;

@Service
public class PayloadBuilderService {

    public String getPayloadForTurningSensorOn(String sensorName) {
        Payload payload = Payload.builder()
                .channel("0" + Sensor.getSensorNumberFromName(sensorName))
                .value("0000")
                .reversed("FF")
                .build();
        return payload.getChannel() + payload.getValue() + payload.getReversed();
    }

    public String getPayloadForTurningSensorOff(String sensorName) {
        Payload payload = Payload.builder()
                .channel("0" + Sensor.getSensorNumberFromName(sensorName))
                .value("0100")
                .reversed("FF")
                .build();
        return payload.getChannel() + payload.getValue() + payload.getReversed();
    }

    public String getPayloadForSensorReboot(String sensorName) {
        Payload payload = Payload.builder()
                .channel("controller".equals(sensorName) ? "FF" : "0" + Sensor.getSensorNumberFromName(sensorName))
                .type("10")
                .reversed("FF")
                .build();
        return payload.getChannel() + payload.getType() + payload.getReversed();
    }
}
