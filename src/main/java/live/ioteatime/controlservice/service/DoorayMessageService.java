package live.ioteatime.controlservice.service;

import live.ioteatime.controlservice.dto.DoorayMessageDto;

public interface DoorayMessageService {
    void send(DoorayMessageDto messageDto);
}
