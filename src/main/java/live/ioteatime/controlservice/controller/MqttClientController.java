package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.service.MqttPublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MqttClientController {
    private final MqttPublisherService mqttPublisherService;

    @GetMapping("/temp/point")
    public void publishMessage() {
        mqttPublisherService.publish("test/topic", "message");
    }

}
