package live.ioteatime.controlservice.adaptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "dooray", url = "${feign.dooray.url}")
public interface DoorayMessageAdaptor {
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<String> send(@RequestBody String message);
}
