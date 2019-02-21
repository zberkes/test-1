package training.microservices.test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Value("${something}")
    private String something;

    @RequestMapping("/health")
    public String health() {
        return something;
    }

}
