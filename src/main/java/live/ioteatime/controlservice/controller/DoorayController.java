package live.ioteatime.controlservice.controller;

import live.ioteatime.controlservice.dto.DoorayMessageDto;
import live.ioteatime.controlservice.service.DoorayMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DoorayController {
    private final DoorayMessageService doorayMessageService;

    @PostMapping("/dooray/send")
    public void sendMessage(@RequestBody DoorayMessageDto messageDto) {
        doorayMessageService.send(messageDto);
    }
}
