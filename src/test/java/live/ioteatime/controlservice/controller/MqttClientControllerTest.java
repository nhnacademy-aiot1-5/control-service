package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.service.PayloadBuilderService;
import live.ioteatime.controlservice.service.impl.MqttPublisherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MqttClientController.class)
class MqttClientControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MqttPublisherServiceImpl mqttPublisherService;
    @MockBean
    PayloadBuilderService payloadBuilderService;

    @Test
    void turnSensorOnTest() throws Exception {
        String payload = "on";
        String sensorName = "sensor";
        String devEui = "dev";

        when(payloadBuilderService.getPayloadForTurningSensorOn(sensorName)).thenReturn(payload);
        doNothing().when(mqttPublisherService).publish(devEui,payload);

        mockMvc.perform(get("/sensor/on")
                        .param("sensorName",sensorName)
                        .param("devEui",devEui))
                .andExpect(status().isOk());

        verify(payloadBuilderService).getPayloadForTurningSensorOn(sensorName);
        verify(mqttPublisherService).publish(devEui,payload);
    }

    @Test
    void turnSensorOffTest() throws Exception {
        String payload = "off";
        String sensorName = "sensor";
        String devEui = "dev";

        when(payloadBuilderService.getPayloadForTurningSensorOff(sensorName)).thenReturn(payload);
        doNothing().when(mqttPublisherService).publish(devEui,payload);

        mockMvc.perform(get("/sensor/off")
                        .param("sensorName",sensorName)
                        .param("devEui",devEui))
                .andExpect(status().isOk());

        verify(payloadBuilderService).getPayloadForTurningSensorOff(sensorName);
        verify(mqttPublisherService).publish(devEui,payload);
    }

    @Test
    void rebootSensorTest() throws Exception {
        String payload = "reboot";
        String sensorName = "sensor";
        String devEui = "dev";

        when(payloadBuilderService.getPayloadForSensorReboot(sensorName)).thenReturn(payload);
        doNothing().when(mqttPublisherService).publish(devEui,payload);

        mockMvc.perform(get("/sensor/reboot")
                        .param("sensorName",sensorName)
                        .param("devEui",devEui))
                .andExpect(status().isOk());

        verify(payloadBuilderService).getPayloadForSensorReboot(sensorName);
        verify(mqttPublisherService).publish(devEui,payload);
    }

}
