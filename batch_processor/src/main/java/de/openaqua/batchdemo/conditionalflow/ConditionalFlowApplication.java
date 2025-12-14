package de.openaqua.batchdemo.conditionalflow;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ConditionalFlowApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ConditionalFlowApplication.class, args);
    }

    @Override
    public void run(String... args) {
        log.info("Running conditional flow application...");
    }
}