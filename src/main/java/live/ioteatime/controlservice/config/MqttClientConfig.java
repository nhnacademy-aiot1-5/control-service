package live.ioteatime.controlservice.config;

import live.ioteatime.controlservice.exception.MqttClientException;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MqttClientConfig {
    @Value("${mqtt.host}")
    String host;
    @Value("${mqtt.name}")
    String name;

    @Bean
    public MqttClient mqttClient(){
        try {
            MqttClient mqttClient = new MqttClient(host, name);
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
            mqttConnectOptions.setCleanSession(true);
            mqttClient.connect();

            return mqttClient;
        } catch (MqttException e) {
            throw new MqttClientException(e.getMessage(), e);
        }
    }

}
