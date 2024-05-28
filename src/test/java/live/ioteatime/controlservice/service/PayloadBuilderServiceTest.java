package live.ioteatime.controlservice.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class PayloadBuilderServiceTest {
    @Autowired
    private PayloadBuilderService payloadBuilderService;

    @Test
    void getPayloadForTurningSensorOn() {
        Assertions.assertEquals("080100ff", payloadBuilderService.getPayloadForTurningSensorOn("ac"));
        Assertions.assertEquals("070100ff", payloadBuilderService.getPayloadForTurningSensorOn("light"));
    }

    @Test
    void getPayloadForTurningSensorOff() {
        Assertions.assertEquals("080200ff", payloadBuilderService.getPayloadForTurningSensorOff("ac"));
        Assertions.assertEquals("070200ff", payloadBuilderService.getPayloadForTurningSensorOff("light"));
    }

    @Test
    void getPayloadForSensorReboot() {
        Assertions.assertEquals("ff10ff", payloadBuilderService.getPayloadForSensorReboot("controller"));
    }
}