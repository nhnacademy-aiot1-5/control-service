package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.service.MqttPublisherService;
import live.ioteatime.controlservice.service.PayloadBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqttClientController {
    private final MqttPublisherService mqttPublisherService;
    private final PayloadBuilderService payloadBuilderService;

    @GetMapping("/sensor/on")
    public void turnSensorOn(@RequestParam String sensorName, @RequestParam String devEui) {
        String payload = payloadBuilderService.getPayloadForTurningSensorOn(sensorName);
        mqttPublisherService.publish(devEui, payload);
    }

    @GetMapping("/sensor/off")
    public void turnSensorOff(@RequestParam String sensorName, @RequestParam String devEui) {
        String payload = payloadBuilderService.getPayloadForTurningSensorOff(sensorName);
        mqttPublisherService.publish(devEui, payload);
    }

    @GetMapping("/sensor/reboot")
    public void rebootSensor(@RequestParam String sensorName, @RequestParam String devEui) {
        String payload = payloadBuilderService.getPayloadForSensorReboot(sensorName);
        mqttPublisherService.publish(devEui, payload);
    }

}
