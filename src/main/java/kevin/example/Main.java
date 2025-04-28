package kevin.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Objects;

@SpringBootApplication
@Slf4j
public class Main {
    public static void main(String[] args) {
        log.info("project start");
        SpringApplication.run(Main.class);
        log.info("project start success");
    }

}