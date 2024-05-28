package live.ioteatime.controlservice.exception;

public class MqttClientException extends RuntimeException {
    public MqttClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
