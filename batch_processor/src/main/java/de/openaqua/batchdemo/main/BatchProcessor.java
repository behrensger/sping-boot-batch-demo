package de.openaqua.batchdemo.main;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Configuration
@EnableScheduling
@Slf4j
public class BatchProcessor implements CommandLineRunner {


    public static void main(String... args) {
        SpringApplication.run(BatchProcessor.class, args);
    }


    @Override
    public void run(String... args) {
        log.info("Start Application");
    }


}
