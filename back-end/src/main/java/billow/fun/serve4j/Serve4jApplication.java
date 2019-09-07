package billow.fun.serve4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties
public class Serve4jApplication {

    public static void main(String[] args) {
        SpringApplication.run(Serve4jApplication.class, args);
    }

}
