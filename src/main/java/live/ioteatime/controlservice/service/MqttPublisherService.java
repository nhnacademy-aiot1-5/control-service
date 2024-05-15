package live.ioteatime.controlservice.service;

public interface MqttPublisherService {

    /**
     *  토픽과 메세지를 mosquitto broker 에 발행하는 메소드
     * @param topic 보낼 토픽
     * @param message 보낼 메세지
     */
    void publish(String topic, String message);
}
