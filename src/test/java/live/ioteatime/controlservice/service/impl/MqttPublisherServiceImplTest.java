package live.ioteatime.controlservice.service.impl;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MqttPublisherServiceImplTest {
    @Mock
    MqttClient mqttClient;
    @InjectMocks
    MqttPublisherServiceImpl mqttPublisherServiceImpl;

    @Test
    void publish() throws MqttException {
        doNothing().when(mqttClient).publish(anyString(), any());

        mqttPublisherServiceImpl.publish("topic", "message");

        verify(mqttClient).publish(anyString(), any());
    }
}