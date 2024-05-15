package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.service.impl.MqttPublisherServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MqttClientController.class)
class MqttClientControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    MqttPublisherServiceImpl mqttPublisherService;

    @Test
    void publishMessage() throws Exception {
        doNothing().when(mqttPublisherService).publish(anyString(), anyString());

        mockMvc.perform(get("/temp/point")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
