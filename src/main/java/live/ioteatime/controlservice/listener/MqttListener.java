package live.ioteatime.controlservice.listener;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MqttListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        try {
            MqttClient mqttClient = event.getApplicationContext().getBean(MqttClient.class);
            mqttClient.disconnect();
            mqttClient.close();
            log.info("mqtt client disconnected");
        } catch (MqttException e) {
            log.error("mqtt client disconnected error {} ", e.getMessage());
        }
    }

}
