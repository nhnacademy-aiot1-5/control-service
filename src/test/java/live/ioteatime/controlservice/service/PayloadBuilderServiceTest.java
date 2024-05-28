package live.ioteatime.controlservice.service;

import live.ioteatime.controlservice.domain.Sensor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PayloadBuilderServiceTest {
    @Mock
    private MockedStatic<Sensor> sensor;
    private PayloadBuilderService payloadBuilderService;

    @BeforeEach
    void setUp() {
        payloadBuilderService = new PayloadBuilderService();
        given(Sensor.getSensorNumberFromName("ac")).willReturn(8);
        given(Sensor.getSensorNumberFromName("light")).willReturn(7);
    }

    @Test
    void getPayloadForTurningSensorOn() {

        Assertions.assertEquals("080000FF", payloadBuilderService.getPayloadForTurningSensorOn("ac"));
        Assertions.assertEquals("070000FF", payloadBuilderService.getPayloadForTurningSensorOn("light"));
    }

    @Test
    void getPayloadForTurningSensorOff() {

        Assertions.assertEquals("080100FF", payloadBuilderService.getPayloadForTurningSensorOff("ac"));
        Assertions.assertEquals("070100FF", payloadBuilderService.getPayloadForTurningSensorOff("light"));
    }

    @Test
    void getPayloadForSensorReboot() {
        Assertions.assertEquals("FF10FF", payloadBuilderService.getPayloadForSensorReboot("controller"));
        Assertions.assertEquals("0810FF", payloadBuilderService.getPayloadForSensorReboot("ac"));
        Assertions.assertEquals("0710FF", payloadBuilderService.getPayloadForSensorReboot("light"));
    }
}