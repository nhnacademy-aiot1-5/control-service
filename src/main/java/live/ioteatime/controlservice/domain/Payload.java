package live.ioteatime.controlservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Payload {
    private String channel;
    private String type;
    private String value;
    private String reversed;
}
