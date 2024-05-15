package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.service.MqttPublisherService;
import live.ioteatime.controlservice.service.PayloadBuilderService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqttClientController {
    private final MqttPublisherService mqttPublisherService;
    private final PayloadBuilderService payloadBuilderService;

    @GetMapping("/sensor/on")
    public void turnSensorOn(@RequestParam String sensorName, @RequestParam String deviceEui) {
        String payload = payloadBuilderService.getPayloadForTurningSensorOn(sensorName);
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("deviceEui", deviceEui);
        jsonMessage.put("payload", payload);

        mqttPublisherService.publish("test/topic", jsonMessage.toString());
    }

    @GetMapping("/sensor/off")
    public void turnSensorOff(@RequestParam String sensorName, @RequestParam String deviceEui) {
        String payload = payloadBuilderService.getPayloadForTurningSensorOff(sensorName);
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("deviceEui", deviceEui);
        jsonMessage.put("payload", payload);

        mqttPublisherService.publish("test/topic", jsonMessage.toString());
    }

    @GetMapping("/sensor/reboot")
    public void rebootSensor(@RequestParam String sensorName, @RequestParam String deviceEui) {
        String payload = payloadBuilderService.getPayloadForSensorReboot(sensorName);
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("deviceEui", deviceEui);
        jsonMessage.put("payload", payload);

        mqttPublisherService.publish("test/topic", jsonMessage.toString());
    }

}
