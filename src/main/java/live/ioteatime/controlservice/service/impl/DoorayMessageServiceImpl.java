package live.ioteatime.controlservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import live.ioteatime.controlservice.adaptor.DoorayMessageAdaptor;
import live.ioteatime.controlservice.dto.DoorayMessageDto;
import live.ioteatime.controlservice.exception.DoorayMessageException;
import live.ioteatime.controlservice.service.DoorayMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoorayMessageServiceImpl implements DoorayMessageService {
    private final DoorayMessageAdaptor doorayMessageAdaptor;

    @Override
    public void send(DoorayMessageDto messageDto) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String body = objectMapper.writeValueAsString(messageDto);
            doorayMessageAdaptor.send(body);
        } catch (JsonProcessingException e) {
            throw new DoorayMessageException(e.getMessage(), e.getCause());
        }

    }
}
