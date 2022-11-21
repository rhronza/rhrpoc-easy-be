package cz.hronza.rhrpoceasybe.boot;

import cz.hronza.rhrpoceasybe.config.RhrpocEasBeConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({RhrpocEasBeConfiguration.class})
public class RhrpocEasyBeApplication {
    public static void main(String[] args) {

        SpringApplication.run(RhrpocEasyBeApplication.class, args);
    }

}
