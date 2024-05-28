package live.ioteatime.controlservice.service.impl;

import live.ioteatime.controlservice.exception.MqttClientException;
import live.ioteatime.controlservice.service.MqttPublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MqttPublisherServiceImpl implements MqttPublisherService {
    private final MqttClient mqttClient;

    @Override
    public void publish(String topic, String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            mqttMessage.setRetained(true);
            mqttClient.publish(topic, mqttMessage);
            log.info("topic:{} , message:{}", topic, message);

        } catch (MqttException e) {
            throw new MqttClientException(e.getMessage(), e);
        }
    }

}
